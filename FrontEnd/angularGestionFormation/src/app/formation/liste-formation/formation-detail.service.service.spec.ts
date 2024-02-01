import { TestBed } from '@angular/core/testing';

import { FormationDetailServiceService } from './formation-detail.service.service';

describe('FormationDetailServiceService', () => {
  let service: FormationDetailServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FormationDetailServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
