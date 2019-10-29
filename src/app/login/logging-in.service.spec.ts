import { TestBed } from '@angular/core/testing';

import { LoggingInService } from './logging-in.service';

describe('LoggingInService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoggingInService = TestBed.get(LoggingInService);
    expect(service).toBeTruthy();
  });
});
