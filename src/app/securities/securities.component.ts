import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-securities',
  templateUrl: './securities.component.html',
  styleUrls: ['./securities.component.css']
})
export class SecuritiesComponent implements OnInit {
  constructor(
    public route: Router
  ) { }

  ngOnInit() {
  }
  close() {
    // go back to portfolio
    this.route.navigate(['/portfolio']);

  }

}
