import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
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
