import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SharedDataService } from '../../shared-data.service';

@Component({
  selector: 'app-categories-menu',
  templateUrl: './categories-menu.component.html',
  styleUrls: ['./categories-menu.component.css']
})

export class CategoriesMenuComponent {

  backendUrl = "http://localhost:8080/accueil/categories";
  categories: any;
  selectedCategories: string[] = [];
  coutRangeValue: number = 0;
  nombreRangeValue: number = 0;

  constructor(private http: HttpClient, private sharedDataService: SharedDataService) {}

  ngOnInit() 
  {
    this.http.get(this.backendUrl).subscribe(data => {
      this.categories = data;
    });
  }

  onCheckboxChange(category: string)
  {
    if (this.selectedCategories.includes(category)) {
      this.selectedCategories = this.selectedCategories.filter(c => c !== category);
    } else {
      this.selectedCategories.push(category);
    }
    this.sharedDataService.setSelectedCategories(this.selectedCategories);
    console.log('Selected Categories:', this.selectedCategories);
  }

  onCoutRangeChange(event: Event) 
  {
    this.coutRangeValue = parseInt((event.target as HTMLInputElement).value);
    this.sharedDataService.setMaxCout(this.coutRangeValue);
  }

  onNombreRangeChange(event: Event) 
  {
    this.nombreRangeValue = parseInt((event.target as HTMLInputElement).value);
    this.sharedDataService.setMaxNombreHeures(this.nombreRangeValue);
  }
}
