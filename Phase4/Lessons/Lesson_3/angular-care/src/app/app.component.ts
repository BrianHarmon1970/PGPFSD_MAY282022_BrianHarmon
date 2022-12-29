import { Component,OnInit } from '@angular/core';
import {FormBuilder, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
[x: string]: any;


  title = 'angCare';
  status = 'You haven\'t signed up yet';
  name = '';
  submitted = false;
  registerForm: FormGroup ;
  constructor(private formBuilder: FormBuilder) {
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }
  ontyping(event:Event)
  {

    this.name = (<HTMLInputElement>event.target).value;
  }
  signup() {

    this.status = 'Oops! We are working on it!';

  }

  ngOnInit() {
    // this.registerForm = this.formBuilder.group({
    //   firstName: ['firstName', Validators.required],
    //   lastName: ['', Validators.required],
    //   email: ['', [Validators.required, Validators.email]],
    //   password: ['password', [Validators.required, Validators.minLength(6)]]
    // });
  }

  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    //this.password_errors = this.registerForm.controls['password'].errors.minLength ;
    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    alert('Your request has been submitted for approval')
  }
}

