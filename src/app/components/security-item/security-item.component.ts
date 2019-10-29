import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Security } from '../../models/security';
import { SecurityService } from '../../services/security.service';
import { TradeComponent } from 'src/app/trade/trade.component';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-security-item',
  templateUrl: './security-item.component.html',
  styleUrls: ['./security-item.component.css']
})

export class SecurityItemComponent implements OnInit {
  @Input() security: Security;
  @Output() deleteSecurity: EventEmitter<Security> = new EventEmitter();
  dialogResult: any;
  constructor(
    private securityService: SecurityService,
    public dialog: MatDialog
    ) { }

  ngOnInit() {
  }
   // Set Dynamic classes
   setClasses() {
    // tslint:disable-next-line: prefer-const
    let classes = {
      security: true,
      'is-complete': this.security.completed
    };

    return classes;
  }

  onToggle(security) {
    // toggle in ui
    console.log('toggle');
    security.completed = !security.completed;

    // toggle on server
    this.securityService.toggleCompleted(security).subscribe(security =>
      console.log(security));

  }

  OpenTradeDialog(security) {
    const dialogRef = this.dialog.open(TradeComponent, {
        height: '400px',
        width: '600px',
        data: 'This text is passed into the dialog!'
      });
    dialogRef.afterClosed().subscribe(result => {
        console.log(`Dialog closed: ${result}`);
        this.dialogResult = result;
      });
  }

}
