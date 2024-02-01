import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, inject, TemplateRef } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-formateur-externe',
  templateUrl: './formateur-externe.component.html',
  styleUrls: ['./formateur-externe.component.css']
})
export class FormateurExterneComponent {


  formateursExterne: any[] = [];
  private token: string = "";
  private modalService = inject(NgbModal);
  private Url = 'http://localhost:8080/formateurExterne';
  
  closeResult = '';
  
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.token = localStorage.getItem('token') ?? '';
    this.fetchFormateursExterne();
  }

  fetchFormateursExterne(): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    this.getMesFormateursExterne(headers, this.Url).subscribe(
      (formateursExterne: any[]) => {
        this.formateursExterne = formateursExterne;
        console.log(formateursExterne);
      },
      (error: HttpErrorResponse) => {
        console.error('Error fetching entreprises:', error);
      }
    );
  }

  getMesFormateursExterne(headers: HttpHeaders, url: string): any {
    return this.http.get<any[]>(url, { headers: headers });
  }

  deleteFormateursExterne(id: number): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    this.http.delete<any[]>(`http://localhost:8080/formateurExterne/${id}`, { headers: headers })
      .subscribe(
        () => {
          console.log(`formateurExterne with ID ${id} deleted successfully.`);
          location.reload();
        },
        (error) => {
          console.error(`Error deleting formateurExterne with ID ${id}:`, error);
        }
      );
  }
 

}
