import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  bid: string;
  cid: string;
  sid: string;

  setSId(id: string){
    this.sid = id;
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
