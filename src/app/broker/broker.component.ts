import { Component, OnInit, Input } from '@angular/core';
import { Customer } from '../shared/customer.model';
import { CustomerService } from '../shared/customer.service';
import { CUST } from '../shared/customer-list';

@Component({
  selector: 'app-broker',
  templateUrl: './broker.component.html',
  styleUrls: ['./broker.component.css']
})
export class BrokerComponent implements OnInit {
  @Input()
  customers = CUST;
  constructor(
    customerId: string,
    brokerId: string,
    password: string,
    name: string
  ) { }

  ngOnInit() {
  }

}
