import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import {MAT_DIALOG_DATA} from '@angular/material';


@Component({
  selector: 'app-trade',
  templateUrl: './trade.component.html',
  styleUrls: ['./trade.component.css']
})
export class TradeComponent implements OnInit {

  constructor(
    public thisDialogRef: MatDialogRef<TradeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string
    ) { }

  ngOnInit() {
  }
  onCloseConfirm() {
    this.thisDialogRef.close('Confirm');
  }
  onCloseCancel() {
    this.thisDialogRef.close('Cancel');
  }
}
