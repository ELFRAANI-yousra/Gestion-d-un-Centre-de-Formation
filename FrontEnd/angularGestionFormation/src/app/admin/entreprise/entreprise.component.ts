import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, inject, TemplateRef } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-entreprise',
  templateUrl: './entreprise.component.html',
  styleUrls: ['./entreprise.component.css']
})
export class EntrepriseComponent {
  entreprises: any[] = [];
  private token: string = "";
  private modalService = inject(NgbModal);
  private Url = 'http://localhost:8080/entreprise';
  selectedentreprise: any = {};
  closeResult = '';
  newEntreprise: any = {
    adresse: '',
    email: '',
    nom: '',
    telephone: 0,
    url: '',
  };
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.token = localStorage.getItem('token') ?? '';
    this.fetchEntreprises();
  }

  fetchEntreprises(): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    this.getMesEntreprises(headers, this.Url).subscribe(
      (entreprises: any[]) => {
        this.entreprises = entreprises;
        console.log(entreprises);
      },
      (error: HttpErrorResponse) => {
        console.error('Error fetching entreprises:', error);
      }
    );
  }

  getMesEntreprises(headers: HttpHeaders, url: string): any {
    return this.http.get<any[]>(url, { headers: headers });
  }

  deleteEntreprise(id: number): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    this.http.delete<any[]>(`http://localhost:8080/entreprise/${id}`, { headers: headers })
      .subscribe(
        () => {
          console.log(`Entreprise with ID ${id} deleted successfully.`);
          location.reload();
        },
        (error) => {
          console.error(`Error deleting entreprise with ID ${id}:`, error);
        }
      );
  }
  addEntreprise(form: any): void {
    // Define the headers with the token
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    // Make HTTP POST request to add a new formation
    this.http.post<any>(this.Url, this.newEntreprise, { headers: headers })
      .subscribe(
        () => {
          // Handle success, if needed
          console.log('entreprise added successfully.');
          // Reset the form
          form.resetForm();
          location.reload();

        },
        (error: HttpErrorResponse) => {
          // Handle error, if needed
          console.error('Error adding entreprise:', error);
        }
      );
  }

  editEntreprise(form: any): void {
    // Define the headers with the token
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    // Make HTTP POST request to add a new formation
    this.http.put<any>(this.Url, this.selectedentreprise, { headers: headers })
      .subscribe(
        () => {
          // Handle success, if needed
          console.log('Formation added successfully.');
          // Reset the form
          form.resetForm();
          location.reload();

        },
        (error: HttpErrorResponse) => {
          // Handle error, if needed
          console.error('Error adding formation:', error);
        }
      );
  }

  selectEntrepriseForEdit(entreprise: any): void {
    this.selectedentreprise = entreprise;
    console.log(entreprise)
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
