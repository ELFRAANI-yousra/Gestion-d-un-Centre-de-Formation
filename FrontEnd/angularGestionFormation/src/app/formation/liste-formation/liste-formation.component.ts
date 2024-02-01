import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SharedDataService } from '../../shared-data.service';
import { Router } from '@angular/router';
import { FormationDetailServiceService } from './formation-detail.service.service'; // Update the path

@Component({
  selector: 'app-liste-formation',
  templateUrl: './liste-formation.component.html',
  styleUrls: ['./liste-formation.component.css']
})
export class ListeFormationComponent implements OnInit 
{
  backendUrl = "http://localhost:8080/accueil";
  formations: any;
  lastSelectedCategories: string[] = [];

  constructor(private http: HttpClient, private sharedDataService: SharedDataService,private router: Router,private formationDetailServiceService: FormationDetailServiceService) {}
 
  onEnrollClick(formation: any) 
  {
      this.formationDetailServiceService.setSelectedFormation(formation);
      this.router.navigate(['/formation-detaille']);
  }

  ngOnInit() 
  {
    this.sharedDataService.selectedCategories$.subscribe(selectedCategories => {
    this.lastSelectedCategories = selectedCategories;
    this.loadFormations();
  });


  this.sharedDataService.maxCout$.subscribe(maxCout => 
    {
      this.loadFormations();
    });

    this.sharedDataService.maxNombreHeures$.subscribe(maxNombreHeures => 
    {
      this.loadFormations();
    });
  }

  loadFormations() 
  {

    let url = this.backendUrl;
    const selectedCategories = this.lastSelectedCategories;
    const maxCout = this.sharedDataService.getMaxCout();
    const maxNombreHeures = this.sharedDataService.getMaxNombreHeures();

    if (selectedCategories.length > 0 || maxCout || maxNombreHeures) {
      url += `/filter?`;

      if (selectedCategories.length > 0) {
        const categoriesQueryParam = selectedCategories.join(',');
        url += `categories=${categoriesQueryParam}`;
      }

      if (maxCout) {
        if (selectedCategories.length > 0) {
          url += `&`;
        }
        url += `maxCout=${maxCout}`;
      }

      if (maxNombreHeures) {
        if (selectedCategories.length > 0 || maxCout) {
          url += `&`;
        }
        url += `maxNombreHeures=${maxNombreHeures}`;
      }
    }

    this.http.get(url).subscribe(data => {
      this.formations = data;
    });
  }
}
