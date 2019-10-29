import { Component, OnInit } from '@angular/core';
// path to Security.ts & Security Service
import { Security } from 'src/app/models/security';
import { SecurityService } from '../../services/security.service';

@Component({
  selector: 'app-securities',
  templateUrl: './securities.component.html',
  styleUrls: ['./securities.component.css']
})
export class SecuritiesComponent implements OnInit {

  securities: Security[];

  constructor(private securityService: SecurityService ) { }

  ngOnInit() {
    this.securityService.getSecurity().subscribe(securities => {
      this.securities = securities;
    });
  }

}
