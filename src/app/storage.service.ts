import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  bid: string;
  cid: string;
  sid: string;
  sname: string;
  balance: number;

  setBalance(balance: number){
    this.balance = balance;
  }
  getBalance(): number{
    return this.balance;
  }

  setSname(sname: string){
    this.sname = sname;
  }
  getSname(): string{
    return this.sname;
  }
  setSId(sid: string){
    this.sid = sid;
    console.log("service: sid" + sid + " this: " + this.sid);
  }
  getSId(): string{
    return this.sid;
  }
  setBId(id: string){
    this.sid = id;
  }

  getBId(): string{
    return this.bid;
  }
  setCId(id: string){
    this.cid = id;
  }

  getCId(): string{
    return this.cid;
  }
}
