import { Component } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent 
{
  constructor(private fb: FormBuilder, private http: HttpClient) {
  }

  backEndURL = "http://localhost:8080/login";

  formLogin = this.fb.group({
    nomUtilisateur: [],
    motDePasse: [],
  });

  login() {
    console.log(this.formLogin.value);
  
    this.http.post<any>(this.backEndURL, this.formLogin.value).subscribe(
      response  => {
        const token = response.token;
        const role=response.role;
        localStorage.setItem('token', token);
        localStorage.setItem('role', role);
        if(role == "FORMATEUR")
        {
          this.redirectToHome("/formateur")
        }else 
        if(role =="ADMIN" || role=="ASSISTANT")
        {
          this.redirectToHome("/admin/formation")
        }
        
      
      },
      error => {
        // Handle error if needed
        console.error("Error in login:", error);
      }
    );
  }
  

  redirectToHome(url: string): void {
    window.location.href = url;
  }
  
  

}
