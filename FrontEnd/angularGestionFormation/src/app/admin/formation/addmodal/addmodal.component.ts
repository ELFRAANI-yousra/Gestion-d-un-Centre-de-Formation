import { Component } from '@angular/core';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';

@Component({
  selector: 'app-addmodal',
  templateUrl: './addmodal.component.html',
  styleUrls: ['./addmodal.component.css']
})

export class AddmodalComponent {
  selectedDates: Date[] = [];

  constructor() { }

  addEvent(event: MatDatepickerInputEvent<Date>): void {
    if (event.value !== null) {
      this.selectedDates.push(event.value);
    }
  }

  removeDate(date: Date): void {
    this.selectedDates = this.selectedDates.filter(d => d !== date);
  }
}
