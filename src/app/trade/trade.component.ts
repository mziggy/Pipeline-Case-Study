import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { StorageService } from '../storage.service';


@Component({
  selector: 'app-trade',
  templateUrl: './trade.component.html',
  styleUrls: ['./trade.component.css']
})
export class TradeComponent implements OnInit {
  tradeForm: FormGroup;
  submitted = false;
  cId: string;
  bId: string;
  stockName: string;


  constructor(
    private service: StorageService,
    private formBuilder: FormBuilder,
    private route: Router
    ) { }
  ngOnInit() {
    console.log('Stock name: ' + this.service.getSId());
    this.stockName = this.service.getSId();
    this.cId = this.service.getCId();
    this.bId = this.service.getBId();

    this.tradeForm = this.formBuilder.group({
      bId: ['', Validators.required],
      cId: ['', Validators.required],
      amount: ['', Validators.required],
    });
  }
  get f() { return this.tradeForm.controls; }

  buy() {
    // buy stock
    // add to customer portfolio
    this.onCloseConfirm();
  }
  sell() {
    // sell stock
    // check if customer has enough of this stock in portfolio
    // if not, error message
    this.onCloseConfirm();
  }
  onCloseConfirm() {
    this.submitted = true;
    // don't continue if invalid
    if (this.tradeForm.invalid) {
      return;
    }
    this.route.navigate(['/portfolio']);
  }
  onCloseCancel() {
    this.route.navigate(['/portfolio']);
  }
}
