import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormationDetailleComponent } from './formation-detaille.component';

describe('FormationDetailleComponent', () => {
  let component: FormationDetailleComponent;
  let fixture: ComponentFixture<FormationDetailleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormationDetailleComponent]
    });
    fixture = TestBed.createComponent(FormationDetailleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
