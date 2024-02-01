// evaluation-service.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class EvaluationServiceService 
{
  private individuData: any;

  setIndividuData(data: any) {
    this.individuData = data;
  }

  getIndividuData() {
    return this.individuData;
  }
}
