import { Component, OnInit, Input } from '@angular/core';
import { TradeComponent } from '../trade/trade.component';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';

import { Portfolio } from '../models/portfolio';
import { CustomerPorfolioService } from './customer-porfolio.service';
import { User } from '../shared/user';

import { StorageService } from '../storage.service';

@Component({
  selector: 'app-customer-portfolio',
  templateUrl: './customer-portfolio.component.html',
  styleUrls: ['./customer-portfolio.component.css']
})

export class CustomerPortfolioComponent implements OnInit {
  @Input() public userid: string;


  id = this.service.getCId();
  //balance = this.service.getBalance();
  title = 'Welcome ' + this.id;

  positions: Portfolio[];


  errorMessage: any;
  // positions: { name: string, quantity: number, value: number, cost: number } [] = [
  // { name: 'Shaughn', quantity: 11, value: 12.32, cost: 322},
  // { name: 'Molly', quantity: 21, value: 9999, cost:  454},
  //  { name: 'Dre', quantity: 45, value: 212, cost: 445 },
  // { name: 'Briana', quantity: 78, value: 44, cost: 56 },
  // { name: 'Ali', quantity: 65, value: 23, cost: 75 },
  // { name: 'Claire', quantity: 78, value: 44, cost: 56 },
  //   { name: 'Sumra', quantity: 78, value: 44, cost: 56 }
  //  ];


  constructor(
   public route: Router,

   public portfolioService: CustomerPorfolioService,
   private service: StorageService
  ) { }
  i = 0;
  ngOnInit() {

    this.portfolioService.getProperties().subscribe(
      data => {
        console.log(data);
        this.positions= data;
      }, error => {
          console.log(error);
      }
    );
    console.log('Customer Id: ' + this.service.getCId());
  }

  OpenTradeDialog(i) {
    // navigate to transaction page
    this.service.setSname(this.positions[i].securityName);
    this.service.setSId(this.positions[i].securityId);
    this.route.navigate(['/transaction']);
  }
  OpenDetails(i) {
    // navigate to details page
    this.service.setSname(this.positions[i].securityName);
    this.service.setSId(this.positions[i].securityId);
    console.log("the sid: " + this.positions[i].securityId);
    this.route.navigate(['/security-details']);
  }

  myFunction() {
    // tslint:disable-next-line: one-variable-per-declaration
    let input, filter, table, tr, td, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    table = document.getElementById('port-table');
    tr = table.getElementsByTagName('tr');

  // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName('td')[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = '';
        } else {
          tr[i].style.display = 'none';
        }
      }
    }
  }
}
