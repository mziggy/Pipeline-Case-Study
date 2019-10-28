import { Component, OnInit, Input } from '@angular/core';
import { Customer } from '../shared/customer.model';
import { CUST } from '../shared/customer-list';

@Component({
  selector: 'app-customer-portfolio',
  templateUrl: './customer-portfolio.component.html',
  styleUrls: ['./customer-portfolio.component.css']
})
export class CustomerPortfolioComponent implements OnInit {
  @Input()
  customer: Customer;
  positions = CUST; // will not be cust eventually
  constructor() { }

  ngOnInit() {
  }

}
