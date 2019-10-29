// allows us to inject it into a constructor in a component
// Other than that it's just a simple class with a constructor

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Security } from '../models/security';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  securitiesUrl = 'https://jsonplaceholder.typicode.com/todos';
  // limit the amount of json returned
  securitiesLimit = '?_limit=5';
  constructor(private http: HttpClient) { }

   // Get todos
   getSecurity(): Observable<Security[]> {
    return this.http.get<Security[]>(`${this.securitiesUrl}${this.securitiesLimit}`);
  }

  // Toggle completed
  toggleCompleted(security: Security): Observable<any> {
    const url = `${this.securitiesUrl}/${security.id}`;
    return this.http.put(url, security, httpOptions);

  }

}
