export { CustomService }
class CustomService
{
    checkUserDetails(login:any)
    {
        if( login.emailid=='raj@gamil.com' && login.password == '123' )
            return true ;
        else return false ;
    }
}