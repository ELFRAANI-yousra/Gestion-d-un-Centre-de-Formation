import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailleInscpComponent } from './detaille-inscp.component';

describe('DetailleInscpComponent', () => {
  let component: DetailleInscpComponent;
  let fixture: ComponentFixture<DetailleInscpComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetailleInscpComponent]
    });
    fixture = TestBed.createComponent(DetailleInscpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
