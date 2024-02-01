import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, inject, TemplateRef } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { DatePipe } from '@angular/common';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-planification',
  templateUrl: './planification.component.html',
  styleUrls: ['./planification.component.css']
})
export class PlanificationComponent {



constructor(private http: HttpClient) { }

 





  planification: any[] = [];
  closeResult = '';
  private Url = 'http://localhost:8080/planification';
  private modalService = inject(NgbModal);
  private token: string = ""; 
  formations: any[] = [];
  formateurs:any[]=[];
  entreprises:any[]=[];
  selectedPlanification: any = {};
  selectedFormation: any = {};
  selectedformateur:any={};
  selectedentreprise:any={};
  selectedIndividual:any={};
  selectedDates: Date[] = [];
  ville:string = "";

  newPlanification: any = {
    ville: '',
    formation: '',
    formateur: '',
    entreprise: '',
    MotsCles: '',
    remarques: ''
  };

  newIndividu: any = {
    nom:'',
    prenom:'',
    dateNaissance:'',
    ville:'',
    email:'',
    telephone:'',
}

  ngOnInit(): void {
    // Fetch the token from local storage when the component initializes
    this.token = localStorage.getItem('token') ?? ''; // Provide an empty string as default value
    this.fetchPlanifications();
    this.fetchFormations();
    this.fetchFormateur();
    this.fetchentreprise();

  }

  fetchPlanifications(): void {
    // Define the headers with the token
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}` // Include the token in the 'Authorization' header
    });
    
    // Pass the headers in the HTTP request
    this.getMesFormations(headers,'http://localhost:8080/planification').subscribe(
      (planifications: any[]) => {  
        this.planification = planifications;
        console.log(planifications)  
        this.planification.forEach(formation => {
          this.fetchIndividu(formation.id).subscribe(
            (individus: any[]) => {
              formation.individus = individus;
              formation.individuCount = formation.individus.length;
              console.log( formation.individus)
            },
            (error: HttpErrorResponse) => {
              console.error('Error fetching individus for formation:', error);
            }
          );
          this.fetchDates(formation.id).subscribe(
            (Dates: any[]) => {
              formation.dates = Dates;
              console.log( formation.dates)
            },
            (error: HttpErrorResponse) => {
              console.error('Error fetching dates for planifictiona:', error);
            }
          );
        });   
      },
      (error: HttpErrorResponse) => {  // Define the type of 'error' as 'HttpErrorResponse'
        console.error('Error fetching entreprises:', error);
      }
    );
  }

  
  fetchDates(formationId: number): any {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });
    return this.http.get<any[]>(`http://localhost:8080/date/${formationId}`, { headers: headers });
  }

  fetchIndividu(formationId: number): any {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });
    return this.http.get<any[]>(`http://localhost:8080/individu/planification/${formationId}`, { headers: headers });
  }

  fetchentreprise(): void {
    // Define the headers with the token
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}` // Include the token in the 'Authorization' header
    });
    
    // Pass the headers in the HTTP request
    this.getMesFormations(headers,'http://localhost:8080/entreprise').subscribe(
      (entreprise: any[]) => {  
        this.entreprises = entreprise;
        console.log(entreprise)     
      },
      (error: HttpErrorResponse) => {  // Define the type of 'error' as 'HttpErrorResponse'
        console.error('Error fetching entreprises:', error);
      }
    );
  }

  fetchFormateur(): void {
    // Define the headers with the token
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}` // Include the token in the 'Authorization' header
    });
    
    // Pass the headers in the HTTP request
    this.getMesFormations(headers,'http://localhost:8080/formateur').subscribe(
      (formateur: any[]) => {  
        this.formateurs = formateur;
        console.log(formateur)     
      },
      (error: HttpErrorResponse) => {  // Define the type of 'error' as 'HttpErrorResponse'
        console.error('Error fetching formateurs:', error);
      }
    );
  }

  fetchFormations(): void {
    // Define the headers with the token
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}` // Include the token in the 'Authorization' header
    });

    // Pass the headers in the HTTP request
    this.getMesFormations(headers,this.Url).subscribe(
      (formations: any[]) => {  // Define the type of 'formations' as 'any[]'
        this.formations = formations;
        console.log(formations)
      },
      (error: HttpErrorResponse) => {  // Define the type of 'error' as 'HttpErrorResponse'
        console.error('Error fetching formations:', error);
      }
    );
  }

  getMesFormations(headers: HttpHeaders,Url:string): any {
    return this.http.get<any[]>(`${Url}`, { headers: headers });
    }


  open(content: TemplateRef<any>) {
    this.modalService.open(content,).result.then(
      (result) => {
        this.closeResult = `Closed with: ${result}`;
      },
      (reason) => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      },
    );
  }

  openXl(content: TemplateRef<any>) {
    this.modalService.open(content, { size: 'xl' ,scrollable: true }).result.then(
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

  addFormation(_t46: NgForm) {
    throw new Error('Method not implemented.');
    }
    seePlanifications(arg0: any) {
    throw new Error('Method not implemented.');
    }
    selectFormationForEdit(formation: any): void {
      this.selectedPlanification= formation;
    }
    
    selectIndividual(individu: any): void {
      this.selectedIndividual=individu
    }

    deletePlanification(id: number): void {
      const headers = new HttpHeaders({
        'Authorization': `Bearer ${this.token}`
      });
    
      this.http.delete<any[]>(`http://localhost:8080/planification/${id}`, { headers: headers })
        .subscribe(
          () => {
            // Handle success, if needed
            console.log(`Planification with ID ${id} deleted successfully.`);
            location.reload();
          },
          (error) => {
            // Handle error, if needed
            console.error(`Error deleting Planification with ID ${id}:`, error);
          }
        );
    }

    addEvent(event: MatDatepickerInputEvent<Date>): void {
      if (event.value !== null) {
        this.selectedDates.push(event.value);
      }
    }
  
    removeDate(date: Date): void {
      this.selectedDates = this.selectedDates.filter(d => d !== date);
    }

    editPlanification(form: any): void {
      // Define the headers with the token
      const headers = new HttpHeaders({
        'Authorization': `Bearer ${this.token}`
      });
      const planification={
        
        id:this.selectedPlanification.id,
        formation: { id: this.selectedPlanification.formation.id },
        formateur:{ id:this.selectedPlanification.formateur.id},
        entreprise:{ id:this.selectedPlanification.entreprise.id},
        ville:this.selectedPlanification.ville
      }
  
      // Make HTTP POST request to add a new formation
      this.http.put<any>(this.Url,planification, { headers: headers })
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

    editPlanificationInd(form: any): void {
      // Define the headers with the token
      const headers = new HttpHeaders({
        'Authorization': `Bearer ${this.token}`
      });
      const planification={
        
        id:this.selectedPlanification.id,
        formation: { id: this.selectedPlanification.formation.id },
        formateur:{ id:this.selectedPlanification.formateur.id},
        ville:this.selectedPlanification.ville
      }
  
      // Make HTTP POST request to add a new formation
      this.http.put<any>(this.Url,planification, { headers: headers })
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

    addInd(form: any): void {
      // Define the headers with the token
      const headers = new HttpHeaders({
        'Authorization': `Bearer ${this.token}`
      });

      const individu = {
        planification: { id: this.selectedPlanification.id },
        nom:this.newIndividu.nom,
        prenom:this.newIndividu.prenom,
        dateNaissance:this.newIndividu.dateNaissance,
        ville:this.newIndividu.ville,
        email:this.newIndividu.email,
        telephone:this.newIndividu.telephone,
      };

      // Make HTTP POST request to add a new formation
      this.http.post<any>('http://localhost:8080/individu/planification', individu, { headers: headers })
        .subscribe(
          (response) => {
            // Handle success, if needed
            console.log('induvidu added successfully. '+response);
            // Reset the form
            location.reload();

          },
          (error: HttpErrorResponse) => {
            // Handle error, if needed
            console.error('Error adding individu:', error);
          }
        );
    }

    deleteIndividual(id: number): void {
      const headers = new HttpHeaders({
        'Authorization': `Bearer ${this.token}`
      });
    
      this.http.delete<any[]>(`http://localhost:8080/individu/${id}`, { headers: headers })
        .subscribe(
          () => {
            // Handle success, if needed
            console.log(`Formation with ID ${id} deleted successfully.`);
            location.reload();
          },
          (error) => {
            // Handle error, if needed
            console.error(`Error deleting formation with ID ${id}:`, error);
          }
        );
    }

    editIndividu(form: any): void {
      // Define the headers with the token
      const headers = new HttpHeaders({
        'Authorization': `Bearer ${this.token}`
      });

      const individu = {
        planification: { id: this.selectedPlanification.id },
        id:this.selectedIndividual.id,
        nom:this.selectedIndividual.nom,
        prenom:this.selectedIndividual.prenom,
        dateNaissance:this.selectedIndividual.dateNaissance,
        ville:this.selectedIndividual.ville,
        email:this.selectedIndividual.email,
        telephone:this.selectedIndividual.telephone,
      };

      // Make HTTP POST request to add a new formation
      this.http.put<any>('http://localhost:8080/individu', individu, { headers: headers })
        .subscribe(
          (response) => {
            // Handle success, if needed
            console.log('induvidu edited successfully. '+response);
            // Reset the form
            location.reload();

          },
          (error: HttpErrorResponse) => {
            // Handle error, if needed
            console.error('Error editing individu:', error);
          }
        );
    }

    adddate(form:any):void{

    this.selectedDates.forEach(dateObj => {
      const datePipe = new DatePipe('en-US');
      const formattedDate = datePipe.transform(dateObj, 'yyyy-MM-dd');

      const headers = new HttpHeaders({
        'Authorization': `Bearer ${this.token}`
      });
      
      const payload = {
        date: formattedDate, 
        planification: {id:this.selectedPlanification.id}
      };

      this.http.post<any>('http://localhost:8080/date', payload, { headers: headers })
        .subscribe(
          (response) => {
            // Handle successful response
            console.log('dates created successfully:', response);
            location.reload();
            // Optionally, close the modal or perform other actions
          },
          (error) => {
            // Handle error
            console.error('Error creating dates:', error);
            // Optionally, display an error message to the user
          }
        );
    });
  }

  deleteDate(id: number): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });
  
    this.http.delete<any[]>(`http://localhost:8080/date/${id}`, { headers: headers })
      .subscribe(
        () => {
          // Handle success, if needed
          console.log(`date with ID ${id} deleted successfully.`);
          location.reload();
        },
        (error) => {
          // Handle error, if needed
          console.error(`Error deleting date with ID ${id}:`, error);
        }
      );
  }



}


