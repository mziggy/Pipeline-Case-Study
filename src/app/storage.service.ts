import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  bid: string;
  cid: string;
  setBId(id: string){
    this.bid = id;
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
