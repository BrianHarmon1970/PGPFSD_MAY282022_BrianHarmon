import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  submitted = false;
  registerForm: FormGroup;
  constructor(private formBuilder: FormBuilder) { this.registerForm = formBuilder.group('',null) ;}
  ngOnInit() {
    this.registerForm = this.formBuilder.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(6)]]
    });
}
get f() { return this.registerForm.controls; }
onSubmit() {
  this.submitted = true;
     
  // stop here if form is invalid
  if (this.registerForm.invalid) {
      return;
  }
     
  alert('Your request has been submitted for approval')
}
}
