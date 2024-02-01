import { Component } from '@angular/core';
import { FormBuilder,FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { EvaluationServiceService } from './evaluation-service.service';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-acces-evaluation',
  templateUrl: './acces-evaluation.component.html',
  styleUrls: ['./acces-evaluation.component.css'],
})

export class AccesEvaluationComponent 
{
  
  constructor(private modalService: NgbModal,private fb: FormBuilder, private router: Router, private http: HttpClient, private evaluationServiceService: EvaluationServiceService) { }
  
  individu: any;
  url = "http://localhost:8080/evaluer/";
  myForm = this.fb.group({code: []});

  onSubmit(IndividuContent:any) 
  {
    const aa = this.myForm.get('code')?.value;
    console.log('Value submitted:', aa);

    const uurl = this.url + aa;
    this.http.get(uurl).subscribe(data => {
      
      this.individu = data;

      if (this.individu == null) 
      {
        this.openSuccessModal(IndividuContent);
      } 
      else 
      {
        this.evaluationServiceService.setIndividuData(this.individu);
        this.router.navigate(['/evaluation']); 
      }
    });
  }

  redirectToHome() 
  {
    window.location.href = '';
  }

  openSuccessModal(formation:any) 
  {
    const modalRef: NgbModalRef = this.modalService.open(formation, { centered: true });
    modalRef.result.then(
      (result) => {
        console.log('Modal closed:', result);
 
      },
      (reason) => {
        console.log('Modal dismissed:', reason);
  
      }
    );
  }

}
