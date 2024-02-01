import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddmodalComponent } from './addmodal.component';

describe('AddmodalComponent', () => {
  let component: AddmodalComponent;
  let fixture: ComponentFixture<AddmodalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddmodalComponent]
    });
    fixture = TestBed.createComponent(AddmodalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
