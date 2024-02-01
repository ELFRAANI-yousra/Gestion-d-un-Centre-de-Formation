import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-fourmateur-externe',
  templateUrl: './fourmateur-externe.component.html',
  styleUrls: ['./fourmateur-externe.component.css']
})

export class FourmateurExterneComponent {
  form: any;

  constructor(private modalService: NgbModal,private fb: FormBuilder, private http: HttpClient) {
    this.form = this.fb.group({
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      dateNaissance: ['', Validators.required],
      ville: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      telephone: ['', Validators.required],
      motsCles: ['', Validators.required],
      file: [null, Validators.required]
    });
  }

  onSubmit(IndividuContent:any) {
    const formData = new FormData();
    formData.append('nom', this.form.get('nom').value);
    formData.append('prenom', this.form.get('prenom').value);
    formData.append('dateNaissance', this.form.get('dateNaissance').value);
    formData.append('ville', this.form.get('ville').value);
    formData.append('email', this.form.get('email').value);
    formData.append('telephone', this.form.get('telephone').value);
    formData.append('motsCles', this.form.get('motsCles').value);
    formData.append('file', this.form.get('file').value);

    this.http.post<any>('http://localhost:8080/postuler', formData)
      .subscribe(response => {
        console.log('Form submitted successfully', response);
        this.openSuccessModal(IndividuContent);
      }, error => {
        console.error('Error submitting form', error);
      });
  }
  onFileChange(event: any) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.form.get('file').setValue(file);
    }

  }
  redirectToHome() {
    window.location.href = "";
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
}

