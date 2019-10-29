import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { User } from '../shared/user';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoggingInService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*'})
  };

  // Base URL
  private baseUrl = 'http://localhost:8099';

  constructor(private http: HttpClient, private router: Router ) { }

  login(user: User): Observable<any> {
    console.log('In logging-in.service ' + user.id);
    let url = this.baseUrl;
    let params = new HttpParams().set('user', user.id).set('password', user.password);
    console.log(params);
    return this.http.get<User>(url, { params });
  }
}
