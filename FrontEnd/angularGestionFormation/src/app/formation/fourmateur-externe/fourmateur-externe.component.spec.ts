import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FourmateurExterneComponent } from './fourmateur-externe.component';

describe('FourmateurExterneComponent', () => {
  let component: FourmateurExterneComponent;
  let fixture: ComponentFixture<FourmateurExterneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FourmateurExterneComponent]
    });
    fixture = TestBed.createComponent(FourmateurExterneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
