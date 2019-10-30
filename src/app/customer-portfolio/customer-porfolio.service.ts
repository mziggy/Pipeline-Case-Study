import { Injectable } from '@angular/core';
import { Portfolio } from '../models/portfolio';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerPorfolioService {

  constructor(private http: HttpClient) { }

  getProperties(): Observable<Portfolio[]>{
    return this.http.get<Portfolio[]>('htttp://localhost:8099/portfolio/{id}');
  }
}
