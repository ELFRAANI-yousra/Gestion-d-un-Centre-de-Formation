import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SharedDataService {
  private selectedCategoriesSubject: BehaviorSubject<string[]> = new BehaviorSubject<string[]>([]);
  selectedCategories$: Observable<string[]> = this.selectedCategoriesSubject.asObservable();

  private maxCoutSubject: BehaviorSubject<number> = new BehaviorSubject<number>(10000);
  maxCout$: Observable<number> = this.maxCoutSubject.asObservable();

  private maxNombreHeuresSubject: BehaviorSubject<number> = new BehaviorSubject<number>(10000);
  maxNombreHeures$: Observable<number> = this.maxNombreHeuresSubject.asObservable();

  setSelectedCategories(selectedCategories: string[]): void {
    this.selectedCategoriesSubject.next(selectedCategories);
  }

  setMaxCout(maxCout: number): void {
    this.maxCoutSubject.next(maxCout);
  }

  setMaxNombreHeures(maxNombreHeures: number): void {
    this.maxNombreHeuresSubject.next(maxNombreHeures);
  }

  getMaxCout(): number {
    return this.maxCoutSubject.getValue();
  }

  getMaxNombreHeures(): number {
    return this.maxNombreHeuresSubject.getValue();
  }

  getSelectedCategories(): string[] {
    return this.selectedCategoriesSubject.getValue();
  }
}
