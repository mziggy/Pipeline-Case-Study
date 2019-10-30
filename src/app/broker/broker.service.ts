// allows us to inject it into a constructor in a component
// Other than that it's just a simple class with a constructor
// reference: https://angular.io/tutorial/toh-pt4
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Broker } from '../models/Broker';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class BrokerService {
  brokerUrl = 'https://jsonplaceholder.typicode.com/todos';
  // limit the amount of json returned
  brokerLimit = '?_limit=5';
  constructor(private http: HttpClient) { }

  // Get Generic
  getBrokers(): Observable<Broker[]> {
    return this.http.get<Broker[]>(`${this.brokerUrl}${this.brokerLimit}`);
  }
}
