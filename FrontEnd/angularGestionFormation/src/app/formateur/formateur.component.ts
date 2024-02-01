import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'app-formateur',
  templateUrl: './formateur.component.html',
  styleUrls: ['./formateur.component.css']
})
export class FormateurComponent implements OnInit {
  formations: any[] = [];
  private Url = 'http://localhost:8080/mesFormation';
  private token: string = ""; // Add a property to store the token

  constructor(private router: Router,private http: HttpClient) { }

  ngOnInit(): void {
    // Fetch the token from local storage when the component initializes
    this.token = localStorage.getItem('token') ?? ''; // Provide an empty string as default value
    this.fetchFormations();
  }

  fetchFormations(): void {
    // Define the headers with the token
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}` // Include the token in the 'Authorization' header
    });

    // Pass the headers in the HTTP request
    this.getMesFormations(headers).subscribe(
      (formations: any[]) => {  // Define the type of 'formations' as 'any[]'
        this.formations = formations;
        console.log(formations)
        // Fetch dates for each formation
        this.formations.forEach(formation => {
          this.fetchDatesForFormation(formation.id).subscribe(
            (dates: any[]) => {
              formation.dates = dates;
             
            },
            (error: HttpErrorResponse) => {
              console.error('Error fetching dates for formation:', error);
            }
          );
        });
      },
      (error: HttpErrorResponse) => {  // Define the type of 'error' as 'HttpErrorResponse'
        console.error('Error fetching formations:', error);
      }
    );
  }

  getMesFormations(headers: HttpHeaders): any {
    // Pass the headers in the HTTP request
    return this.http.get<any[]>(`${this.Url}`, { headers: headers });
  }

  fetchDatesForFormation(formationId: number): any {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    });
    return this.http.get<any[]>(`http://localhost:8080/date/${formationId}`, { headers: headers });
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']); 
  }
}
