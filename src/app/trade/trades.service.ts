import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Security } from '../models/security';
import { Trade } from '../models/trade';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../shared/user';
import { StorageService } from '../storage.service';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TradesService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*'})
  };

  // Base Url
  private baseUrl = 'http://localhost:8099/transaction';

  constructor(private http: HttpClient, private router: Router, private service: StorageService) { }

  trade(trade: Trade): Observable<any> {
    console.log('In trade.service ' + this.service.getSId());
    let amount: number;
    let url = this.baseUrl;
    let params = new HttpParams().set('brokerId', trade.brokerId).set(amount, trade.amount);
    console.log(params);
    return this.http.post<Trade>(url, { params });
  }
}
