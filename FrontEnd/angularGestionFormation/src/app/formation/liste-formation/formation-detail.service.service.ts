import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FormationDetailServiceService {

  private selectedFormationSubject = new BehaviorSubject<any>(null);
  selectedFormation$ = this.selectedFormationSubject.asObservable();

  setSelectedFormation(formation: any) {
    this.selectedFormationSubject.next(formation);
  }

  getSelectedFormation() {
    // Use subscribe to get the latest value from the observable
    let selectedFormation: any;
    this.selectedFormation$.subscribe(formation => selectedFormation = formation);
    return selectedFormation;
  }
}
