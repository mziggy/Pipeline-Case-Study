import { Component, OnInit, Input } from '@angular/core';
import { Customers } from '../models/customers';
import { BrokerService } from '../broker/broker.service';



@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  @Input()
  customer: Customers[];

  constructor(private brokerService: BrokerService) { }

  ngOnInit() {
    this.brokerService.getCustomersByBrokerId().subscribe(customers => {
      this.customer = customers;
    });

  }

}
