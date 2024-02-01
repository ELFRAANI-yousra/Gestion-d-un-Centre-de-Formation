import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';

import { EvaluationServiceService } from '../acces-evaluation/evaluation-service.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-evaluation',
  templateUrl: './evaluation.component.html',
  styleUrls: ['./evaluation.component.css'],
})

export class EvaluationComponent 
{
  constructor(
    private modalService: NgbModal,
    private fb: FormBuilder,
    private http: HttpClient,
    private evaluationServiceService: EvaluationServiceService
  ) {}
  
  backEndURL1 = 'http://localhost:8080/evaluation';
  backEndURL2 = 'http://localhost:8080/rejoindre/evaluer';
  PedagogicalNote: number = 0;
  NoteRythme: number = 0;
  NoteSupport: number = 0;
  NoteMaitrise: number = 0;
  individu: any;
  stars: number[] = [1, 2, 3, 4, 5];
  formEvaluation = this.fb.group({
    notePedagogique: [0],
    noteRythme: [0],
    noteSupportCoursTP: [0],
    noteMaitriseSujet: [0],
    planification: [null],
    individu: [null],
  });

  captureRatings(IndividuContent:any) 
  {
    const id=this.individu.id;
    console.log(id);
    this.http.post(this.backEndURL2,id).subscribe()
    this.formEvaluation.patchValue({ notePedagogique: this.PedagogicalNote });
    this.formEvaluation.patchValue({ noteRythme: this.NoteRythme });
    this.formEvaluation.patchValue({ noteSupportCoursTP: this.NoteSupport });
    this.formEvaluation.patchValue({ noteMaitriseSujet: this.NoteMaitrise });
    this.formEvaluation.patchValue({ planification: this.individu.planification });
    this.formEvaluation.patchValue({ individu: this.individu });

    console.log(this.formEvaluation.value);
    
    this.http.post(this.backEndURL1, this.formEvaluation.value).subscribe(
      () => {
        this.openSuccessModal(IndividuContent);
      },
      (error) => {
        console.error('Error evaluation form:', error);
      }
    );
  }

  ngOnInit(): void 
  {
    this.individu = this.evaluationServiceService.getIndividuData();
    console.log('Individu in EvaluationComponent:', this.individu);
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
        this.redirectToHome();
      },
      (reason) => {
        console.log('Modal dismissed:', reason);
        this.redirectToHome();
      }
    );
  }

  setRating(rating: number, category: string): void 
  {
    switch (category) {
      case 'PedagogicalNote':
        this.PedagogicalNote = rating;
        break;
      case 'NoteRythme':
        this.NoteRythme = rating;
        break;
      case 'NoteSupport':
        this.NoteSupport = rating;
        break;
      case 'NoteMaitrise':
        this.NoteMaitrise = rating;
        break;
      default:
        break;
    }
  }
}
