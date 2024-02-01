import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FourmateurComponent } from './fourmateur.component';

describe('FourmateurComponent', () => {
  let component: FourmateurComponent;
  let fixture: ComponentFixture<FourmateurComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FourmateurComponent]
    });
    fixture = TestBed.createComponent(FourmateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
