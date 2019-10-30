import { TestBed } from '@angular/core/testing';

import { CustomerPorfolioService } from './customer-porfolio.service';

describe('CustomerPorfolioService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerPorfolioService = TestBed.get(CustomerPorfolioService);
    expect(service).toBeTruthy();
  });
});
