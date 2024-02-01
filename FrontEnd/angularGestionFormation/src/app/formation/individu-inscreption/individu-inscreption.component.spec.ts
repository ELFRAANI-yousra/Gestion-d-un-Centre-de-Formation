import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndividuInscreptionComponent } from './individu-inscreption.component';

describe('IndividuInscreptionComponent', () => {
  let component: IndividuInscreptionComponent;
  let fixture: ComponentFixture<IndividuInscreptionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IndividuInscreptionComponent]
    });
    fixture = TestBed.createComponent(IndividuInscreptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
