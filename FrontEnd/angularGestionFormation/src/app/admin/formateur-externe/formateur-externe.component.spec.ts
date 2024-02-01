import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormateurExterneComponent } from './formateur-externe.component';

describe('FormateurExterneComponent', () => {
  let component: FormateurExterneComponent;
  let fixture: ComponentFixture<FormateurExterneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormateurExterneComponent]
    });
    fixture = TestBed.createComponent(FormateurExterneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
