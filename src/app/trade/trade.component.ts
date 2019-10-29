import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import {MAT_DIALOG_DATA} from '@angular/material';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-trade',
  templateUrl: './trade.component.html',
  styleUrls: ['./trade.component.css']
})
export class TradeComponent implements OnInit {
  tradeForm: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    public thisDialogRef: MatDialogRef<TradeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string
    ) { }

  ngOnInit() {
    this.tradeForm = this.formBuilder.group({
      bId: ['', Validators.required],
      cId: ['', Validators.required],
      amount: ['', Validators.required],
    });
  }
  get f() { return this.tradeForm.controls; }

  buy() {
    this.onCloseConfirm();
  }
  sell() {
    this.onCloseConfirm();
  }
  onCloseConfirm() {
    this.submitted = true;
    // don't continue if invalid
    if (this.tradeForm.invalid) {
      console.log('returned');

      return;
    }
    this.thisDialogRef.close('Confirm');
  }
  onCloseCancel() {
    this.thisDialogRef.close('Cancel');
  }
}
