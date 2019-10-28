import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private route: Router) { }

  ngOnInit() {
  }

  login() {
    // check if login works and who is logging in
    // if credentials correct then route to new page
    // else error
    this.route.navigate(['/dashboard']);
  }

}
