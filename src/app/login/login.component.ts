import { Component, OnInit } from '@angular/core';
import {Validators, FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from '../user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  submitted = false;

  constructor(
    private route: Router,
    private formBuilder: FormBuilder,
    private authService: AuthService
    ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      id: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
  get f() { return this.loginForm.controls; }


  login() {
    this.submitted = true;
    // don't continue if invalid
    if (this.loginForm.invalid) {
      return;
    }
    this.authService.login(this.loginForm.value)
    // check if login works and who is logging in
    // if credentials correct then route to new page
    // else error

    if (this.f.id.value[0] === 'b') {
      this.route.navigate(['/dashboard']);
    }
    if (this.f.id.value[0] === 'c'){
      this.route.navigate(['/portfolio']);
    }
    this.loginForm.reset();
    return;
  }

}
