import { Component, OnInit } from '@angular/core';
import {Validators, FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { LoggingInService } from './logging-in.service';
import { User } from '../shared/user';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  constructor(public loginService: LoggingInService,
              public router: Router,
              private authService: AuthService,
              public formBuilder: FormBuilder) {}
  loginForm: FormGroup;
  submitted = false;


  get id() {
    return this.loginForm.get('id');
  }

  get password() {
    return this.loginForm.get('password');
  }
  public user = new User();

  get f() { return this.loginForm.controls; }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      id: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  checkLogon() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      console.log('invalid');
      return;
    }
    // this.authService.login(this.loginForm.value);
    if (this.user === null) {
      alert("Try again.");
    }
    if (this.user != null) {
      if (this.user.id[0] === 'B') {
        this.router.navigate(['/dashboard']);
      }
      if (this.user.id[0] === 'C') {
          this.router.navigate(['/portfolio']);
      }
      this.loginForm.reset();
    }
    return;
  }
    // create the form object

    Login() {
      this.user.id = this.id.value;
      this.user.password = this.password.value;
      console.log('This sessions userId is: ' + this.user.id);
      console.log('The password is: ' + this.user.password);
      this.checkLogon();

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
