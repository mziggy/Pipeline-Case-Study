import { Component, OnInit } from '@angular/core';
import {Validators, FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { LoggingInService } from './logging-in.service';
import { User } from '../shared/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  constructor(private loginService: LoggingInService, private router: Router) {}
  loginForm: FormGroup;


  get id() {
    return this.loginForm.get('id');
  }

  get password() {
    return this.loginForm.get('password');
  }
  private user = new User();

  ngOnInit() {
    this.loginForm = new FormGroup({
      id: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
  }

  checkLogon() {
    if(this.user != null){
    if (this.user.id[0] === 'B') {
      this.router.navigate(['/dashboard']);
    }
    if (this.user.id[0] === 'C') {
        this.router.navigate(['/portfolio']);
      }
    }
  }
    // create the form object

    Login() {
      this.user.id = this.id.value;
      this.user.password = this.password.value;
      console.log('This sessions userId is: ' + this.user.id);
      console.log('The password is: ' + this.user.password);

      this.loginService.login(this.user).subscribe(
        data => {
          console.log('------->' +  data);
          console.log(data);
          this.user = data;
          this.checkLogon();
        }, error => {
          console.log('ERROR HERE' + error);
        }
      );
    }
  }
