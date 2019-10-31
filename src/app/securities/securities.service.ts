import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { StorageService } from '../storage.service';
import { Observable } from 'rxjs';
import { Security } from '../models/security';

@Injectable({
  providedIn: 'root'
})
export class SecuritiesService {
  private baseURL = 'http://localhost:8099/security-details';

  constructor(private http: HttpClient, private router: Router, private service: StorageService) { }

  getSecurities(): Observable<Security[]> {
    console.log('In cust-prof.service ' + this.service.getSId());
    let url = this.baseURL + '/' + this.service.getSId();
    console.log(url);
    return this.http.get<Security[]>(url);
  }
}
