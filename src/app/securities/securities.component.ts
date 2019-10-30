import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-securities',
  templateUrl: './securities.component.html',
  styleUrls: ['./securities.component.css']
})
export class SecuritiesComponent implements OnInit {
  constructor(
    public route: Router,
    private service: StorageService
  ) { }

  stockName: string = this.service.getSId();

  ngOnInit() {
  }
  close() {
    // go back to portfolio
    this.route.navigate(['/portfolio']);

  }

}
