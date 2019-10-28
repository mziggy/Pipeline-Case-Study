import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material';

@Component({
  selector: 'app-trade',
  templateUrl: './trade.component.html',
  styleUrls: ['./trade.component.css']
})
export class TradeComponent implements OnInit {
  dialogResult: any;

  constructor(
    public dialog: MatDialog
    ) { }

  ngOnInit() {
  }

// should be put in securities component ts
  openDialog() {
    console.log("open dialog!!");
    // tslint:disable-next-line: prefer-const
    let dialogRef = this.dialog.open(TradeComponent, {
      width: '600px',
      data: 'This text is passed into the dialog!'
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog closed: ${result}`);
      this.dialogResult = result;
    });
  }
}
