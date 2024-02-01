
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, inject, TemplateRef } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-fourmateur',
  templateUrl: './fourmateur.component.html',
  styleUrls: ['./fourmateur.component.css']
})
export class FourmateurComponent {

  fourmateurs: any[] = [];
  private token: string = "";
  private modalService = inject(NgbModal);
  private Url = 'http://localhost:8080/formateur';
  selectedFourmateur: any = {};
  closeResult = '';
  newFourmateur: any = {
    nom: '',
    prenom: '',
    email: '',
    motDePasse:'',
    motsCles: '',
    remarques:'', 
  };
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.token = localStorage.getItem('token') ?? '';
    this.fetchFourmateurs();
  }

  fetchFourmateurs(): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    this.getMesFourmateurs(headers, this.Url).subscribe(
      (fourmateurs: any[]) => {
        this.fourmateurs = fourmateurs;
        console.log(fourmateurs);
      },
      (error: HttpErrorResponse) => {
        console.error('Error fetching fourmateurs:', error);
      }
    );
  }

  getMesFourmateurs(headers: HttpHeaders, url: string): any {
    return this.http.get<any[]>(url, { headers: headers });
  }

  deleteFourmateur(id: number): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    this.http.delete<any[]>(`http://localhost:8080/formateur/${id}`, { headers: headers })
      .subscribe(
        () => {
          console.log(`formateur with ID ${id} deleted successfully.`);
          location.reload();
        },
        (error) => {
          console.error(`Error deleting entreprise with ID ${id}:`, error);
        }
      );
  }
  addFourmateur(form: any): void {
    // Define the headers with the token
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    // Make HTTP POST request to add a new formation
    this.http.post<any>(this.Url, this.newFourmateur, { headers: headers })
      .subscribe(
        () => {
          // Handle success, if needed
          console.log('fourmateur added successfully.');
          // Reset the form
          form.resetForm();
          location.reload();

        },
        (error: HttpErrorResponse) => {
          // Handle error, if needed
          console.error('Error adding fourmateur:', error);
        }
      );
  }

  editFourmateur(form: any): void {
    // Define the headers with the token
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    // Make HTTP POST request to add a new formation
    this.http.put<any>(this.Url, this.selectedFourmateur, { headers: headers })
      .subscribe(
        () => {
          // Handle success, if needed
          console.log('Fourmateur added successfully.');
          // Reset the form
          form.resetForm();
          location.reload();

        },
        (error: HttpErrorResponse) => {
          // Handle error, if needed
          console.error('Error adding Fourmateur:', error);
        }
      );
  }

  selectFourmateurForEdit(fourmateur: any): void {
    this.selectedFourmateur = fourmateur;
    console.log(fourmateur)
  }

  open(content: TemplateRef<any>) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
      (result) => {
        this.closeResult = `Closed with: ${result}`;
      },
      (reason) => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      },
    );
  }
  private getDismissReason(reason: any): string {
    switch (reason) {
      case ModalDismissReasons.ESC:
        return 'by pressing ESC';
      case ModalDismissReasons.BACKDROP_CLICK:
        return 'by clicking on a backdrop';
      default:
        return `with: ${reason}`;
    }
  }
}
