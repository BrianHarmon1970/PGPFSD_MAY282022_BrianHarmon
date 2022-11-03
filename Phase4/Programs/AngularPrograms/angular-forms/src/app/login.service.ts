export { LoginService }
import { Injectable } from '@angular/core'

@Injectable()
class LoginService
{
    checkUserDetails( login:any )
    {
        if( login.emailid == 'raj@gmail.com' && login.password == '123')
            return true ;
        else return false ;
    }
}