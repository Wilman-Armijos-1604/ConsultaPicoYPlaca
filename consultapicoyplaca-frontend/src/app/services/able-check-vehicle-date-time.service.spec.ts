import { TestBed } from '@angular/core/testing';

import { AbleCheckVehicleDateTimeService } from './able-check-vehicle-date-time.service';

describe('AbleCheckVehicleDateTimeService', () => {
  let service: AbleCheckVehicleDateTimeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AbleCheckVehicleDateTimeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
