import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { StorageService } from '../storage.service';
import { Trade } from '../models/trade';
import { TradesService } from './trades.service';
import { Security } from '../models/security';


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
    private tradeService: TradesService,
    private formBuilder: FormBuilder,
    private route: Router,
    ) { }

    get amount() {
      return this.tradeForm.get('amount');
    }

    get BId() {
      return this.tradeForm.get('bId');
    }

    public trade = new Trade();

    get f() { return this.tradeForm.controls; }

  ngOnInit() {
    console.log('Stock name: ' + this.service.getSId());
    this.stockName = this.service.getSname();
    this.cId = this.service.getCId();
    this.bId = this.service.getBId();

    this.tradeForm = this.formBuilder.group({
      bId: ['', Validators.required],
      cId: ['', Validators.required],
      amount: ['', Validators.required],
    });
  }


  buy() {
    // buy stock
    // add to customer portfolio
    this.tradeService.trade(this.trade).subscribe(
      data => {
        console.log('--->' + data);
        console.log(data);
        this.trade = data;
        console.log('done');
      }, error => {
        console.log('ERROR HERE' + error);
      }
    );
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
