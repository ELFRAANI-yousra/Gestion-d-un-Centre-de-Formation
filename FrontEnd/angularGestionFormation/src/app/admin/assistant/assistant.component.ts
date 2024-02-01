import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, inject, TemplateRef } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-assistant',
  templateUrl: './assistant.component.html',
  styleUrls: ['./assistant.component.css']
})
export class AssistantComponent {


  assistants: any[] = [];
  private token: string = "";
  private modalService = inject(NgbModal);
  private Url = 'http://localhost:8080/assistant';
  selectedAssistant: any = {};
  closeResult = '';
  newAssistant: any = {
    nom: '',
    prenom: '',
    nomUtilisateur: '',
    motDePasse:'',
    adresse: '',
    telephone:0, 



  };

  columnsToDisplay: string[] = ['id', 'nom', 'prenom', 'email', 'motDePasse', 'adresse', 'telephone', 'actions'];




  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.token = localStorage.getItem('token') ?? '';
    this.fetchAssistants();
  }

  fetchAssistants(): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    this.getMesAssistants(headers, this.Url).subscribe(
      (assistants: any[]) => {
        this.assistants = assistants;
        console.log(assistants);
      },
      (error: HttpErrorResponse) => {
        console.error('Error fetching assistants:', error);
      }
    );
  }

  getMesAssistants(headers: HttpHeaders, url: string): any {
    return this.http.get<any[]>(url, { headers: headers });
  }

  deleteAssistant(id: number): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    this.http.delete<any[]>(`http://localhost:8080/assistant/${id}`, { headers: headers })
      .subscribe(
        () => {
          console.log(`Assistant with ID ${id} deleted successfully.`);
          location.reload();
        },
        (error) => {
          console.error(`Error deleting Assistant with ID ${id}:`, error);
        }
      );
  }
  addAssistant(form: any): void {

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });


    this.http.post<any>(this.Url, this.newAssistant, { headers: headers })
      .subscribe(
        () => {
      
          console.log('fourmateur added successfully.');
  
          form.resetForm();
          location.reload();

        },
        (error: HttpErrorResponse) => {
      
          console.error('Error adding fourmateur:', error);
        }
      );
  }

  editAssistant(form: any): void {

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });
    console.log(this.selectedAssistant)
 
   const editAssistant={
    id: this.selectedAssistant.id,
    nom:this.selectedAssistant.nom,
    prenom: this.selectedAssistant.prenom,
    nomUtilisateur:this.selectedAssistant.nomUtilisateur,
    motDePasse: this.selectedAssistant.motDePasse,
    adresse: this.selectedAssistant.adresse,
    telephone: this.selectedAssistant.telephone }; 
    this.http.put<any>(this.Url, editAssistant, { headers: headers })
      .subscribe(
        (response) => {
          // Handle success, if needed
          console.log('Assistant added successfully.',response);

          form.resetForm();
          location.reload();

        },
        (error: HttpErrorResponse) => {
          // Handle error, if needed
          console.error('Error adding Assistant:', error);
        }
      );
  }

  selectAssistantForEdit(assistant: any): void {
    this.selectedAssistant = assistant;
    console.log(assistant)
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

