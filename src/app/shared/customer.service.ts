import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { CUST } from './customer-list';
import { Customer } from './customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor() { }
  list(): Observable<Customer[]> {
    return of(CUST);
  }
}
