import { Injectable } from '@angular/core';
import { Customers } from '../models/customers';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BrokerService {
  brokerUrl = 'http://localhost:8080/broker/customers/{id}';
  brokerUrl2 = 'http://localhost:8080/customer/{id}';
  constructor(private http: HttpClient) { }

  getCustomersByBrokerId(): Observable<Customers[]> {
    return this.http.get<Customers[]>(`${this.brokerUrl}`);
  }

  getCustomersByCustomerId(): Observable<Customers[]> {
    return this.http.get<Customers[]>(`${this.brokerUrl2}`);
  }





}
