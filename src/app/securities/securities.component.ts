import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from '../storage.service';
import { Security } from '../models/security';
import { SecuritiesService } from './securities.service';

@Component({
  selector: 'app-securities',
  templateUrl: './securities.component.html',
  styleUrls: ['./securities.component.css']
})
export class SecuritiesComponent implements OnInit {
  securities: Security[];
  errorMessage: any;

  constructor(
    private service: StorageService,
    private securesercive: SecuritiesService,
    public route: Router
  ) { }

  stockname: string = this.service.getSname();
  // stockid: string = this.service.getSId();

  ngOnInit() {
    this.securesercive.getSecurities().subscribe(
      data => {
        console.log(data);
        this.securities = data;
      }, error => {
        console.log(error);
      }
    );
  }
  close() {
    // go back to portfolio
    this.route.navigate(['/portfolio']);

  }

}
