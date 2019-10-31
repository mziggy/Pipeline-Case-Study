import { Component, OnInit, Input } from '@angular/core';
import { TradeComponent } from '../trade/trade.component';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';

import { Portfolio } from '../models/portfolio';
import { CustomerPorfolioService } from './customer-porfolio.service'; //imports probably need changed!!
import { User } from '../shared/user';

import { StorageService } from '../storage.service';

@Component({
  selector: 'app-customer-portfolio',
  templateUrl: './customer-portfolio.component.html',
  styleUrls: ['./customer-portfolio.component.css']
})

export class CustomerPortfolioComponent implements OnInit {

  positions: Portfolio[]; //probably change this!!
  errorMessage: any;

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
      exists = false;
      td = tr[i].getElementsByTagName('td')[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          exists = true;
        }
      }
      td = tr[i].getElementsByTagName('td')[1];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          exists = true;
        }
      }
      console.log(tr[i].className);
      if (exists || tr[i].className === 'header') {
        // search exists in table and the element isn't the header
        tr[i].style.display = '';
      } else {
        tr[i].style.display = 'none';
      }
    }
  }
}
