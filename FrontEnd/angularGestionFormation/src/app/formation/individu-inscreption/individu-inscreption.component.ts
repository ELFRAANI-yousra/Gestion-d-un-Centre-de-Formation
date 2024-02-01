import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormationDetailServiceService } from '../liste-formation/formation-detail.service.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-individu-inscreption',
  templateUrl: './individu-inscreption.component.html',
  styleUrls: ['./individu-inscreption.component.css']
})

export class IndividuInscreptionComponent
{
  selectedFormation: any = null;

  constructor(private modalService: NgbModal,private fb: FormBuilder, private http: HttpClient, private formationDetailServiceService: FormationDetailServiceService) {
    this.selectedFormation = this.formationDetailServiceService.getSelectedFormation();
  }

  backEndURL = "http://localhost:8080/rejoindre";

  formIndividu = this.fb.group({
    nom: [],
    prenom: [],
    dateNaissance: [],
    ville: [],
    email: [],
    telephone: [],
    formation:[]
  });

  addIndividu(formation:any) 
  {
    console.log(this.formIndividu.value);
    this.formIndividu.patchValue({formation:this.selectedFormation});
    this.http.post(this.backEndURL, this.formIndividu.value).subscribe(
    () => {
      this.openSuccessModal(formation);
    },
    error => {
      console.error("Error inscreption form:", error);
    }
  );
}

redirectToHome() 
{
  window.location.href = "";
};

openSuccessModal(formation:any) {
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

}

