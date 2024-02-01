import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccesEvaluationComponent } from './acces-evaluation.component';

describe('AccesEvaluationComponent', () => {
  let component: AccesEvaluationComponent;
  let fixture: ComponentFixture<AccesEvaluationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AccesEvaluationComponent]
    });
    fixture = TestBed.createComponent(AccesEvaluationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
