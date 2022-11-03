import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl } from '@angular/forms'
import { AppComponent } from '../app.component';
import { AppModule } from '../app.module';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login-mdf',
  templateUrl: './login-mdf.component.html',
  styleUrls: ['./login-mdf.component.css']
})
export class LoginMdfComponent implements OnInit {
  ngOnInit(): void {
  }
  msg:string = "" ;
  public loginRef = new FormGroup(
    { 
      emailid:new FormControl(), 
      password:new FormControl()
    }
    ) ; 

  constructor( public login:LoginService ){}
  
  onSubmit(  )
  {
    if ( this.login.checkUserDetails(this.loginRef.value)) 
      this.msg = "Successful Login" ;
    else( this.msg = "Login Fail" ) ;
    this.loginRef.reset() ;
    console.log( this.msg ) ;
    //return this.msg ;
    
    //this.msg = "TestMessage" ; 
    //console.log( "email", this.login.loginRef.value.emailid ) ;
    //console.log( "password", this.loginRef.value.password ) ;

  }
}
