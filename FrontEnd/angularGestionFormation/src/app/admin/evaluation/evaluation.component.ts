
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, inject, TemplateRef } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-evaluation',
  templateUrl: './evaluation.component.html',
  styleUrls: ['./evaluation.component.css']
})

export class EvaluationComponent {


  evaluations: any[] = [];
  private token: string = "";
  private modalService = inject(NgbModal);
  private Url = 'http://localhost:8080/evaluation';
  
  closeResult = '';
  
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.token = localStorage.getItem('token') ?? '';
    this.fetchEvaluationsExterne();
  }

  fetchEvaluationsExterne(): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    this.getMesEvaluations(headers, this.Url).subscribe(
      (evaluations: any[]) => {
        this.evaluations = evaluations;
        console.log(evaluations);
      },
      (error: HttpErrorResponse) => {
        console.error('Error fetching evaluations:', error);
      }
    );
  }

  getMesEvaluations(headers: HttpHeaders, url: string): any {
    return this.http.get<any[]>(url, { headers: headers });
  }

  deleteEvaluation(id: number): void {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });

    this.http.delete<any[]>(`http://localhost:8080/evaluation/${id}`, { headers: headers })
      .subscribe(
        () => {
          console.log(`evaluation with ID ${id} deleted successfully.`);
          location.reload();
        },
        (error) => {
          console.error(`Error deleting evaluation with ID ${id}:`, error);
        }
      );
  }
 

}
