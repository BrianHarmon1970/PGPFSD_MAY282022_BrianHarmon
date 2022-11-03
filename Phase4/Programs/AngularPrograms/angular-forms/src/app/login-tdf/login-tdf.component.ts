import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'
import { CustomService } from "../custom.service"
import { LoginService } from '../login.service';
@Component({
  selector: 'app-login-tdf',
  templateUrl: './login-tdf.component.html',
  styleUrls: ['./login-tdf.component.css']
})
export class LoginTdfComponent implements OnInit {
  msg:string = "" ;

  constructor( public ls:LoginService) { }

  ngOnInit(): void {
  }
  checkUser( loginRef:NgForm )
  {
    let login= loginRef.value ;
    //if ( login.emailid == 'raj@gmail.com' && login.password=='123')
    //  this.msg = "Successful login" ;
    //else this.msg = "Login Fail" ;

    //let cs = new CustomService() ;
     //if (cs.checkUserDetails(login) == true )
    //  this.msg="Login Success" ;
    //else this.msg= "Login Fail" ;
    this.msg = this.ls.checkUserDetails(login) ? "Success" : "Fail" ;

    loginRef.reset() ;
  }

}
