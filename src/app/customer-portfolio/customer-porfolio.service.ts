import { Injectable } from '@angular/core';
import { Portfolio } from '../models/portfolio';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { StorageService } from '../storage.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CustomerPorfolioService {
  private baseURL = 'http://localhost:8099/portfolio';

  constructor(private http: HttpClient, private router: Router, private service: StorageService ) { }

  getProperties(): Observable<Portfolio[]>{
    console.log('In cust-prof.service ' + this.service.getCId());
    let url = this.baseURL + '/' + this.service.getCId();
    console.log(url);
    return this.http.get<Portfolio[]>(url);
  }
}
