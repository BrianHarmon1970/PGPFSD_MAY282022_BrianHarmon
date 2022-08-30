package com.harmonengineering.beans;
/*enum SessionState
{
    RecordSelected ,
    LoginRegister,
    LoginRegisterConfirmed,
    Booking,
    BookingConfirmed ,
    Payment,
    PaymentConfirmed,
    Final,
    Update,
    Reset
}*/
public class SessionStatusBean
{
    private SessionState sessionState ;
    private boolean     verifiedLogin ;
    private String      userLoginName ;

    public static enum SessionState
    {
        RecordSelected ,
        LoginRegister,
        LoginRegisterConfirmed,
        Booking,
        BookingConfirmed ,
        Payment,
        PaymentConfirmed,
        Final,
        Update,
        Reset
    }
    public SessionStatusBean()
    {
        sessionState = SessionState.Final ;
        verifiedLogin = false ;
    }
    public void setSessionState(SessionState sessionState)
    {
        assert ( sessionState == SessionState.Update ||
                    sessionState == SessionState.Reset ) ;
        SessionState status = this.sessionState;
        System.out.print( this.sessionState + " --> ");
        switch ( status )
        {
            case Final: status = SessionState.RecordSelected ; break ;
            case RecordSelected: status = SessionState.LoginRegister ; break ;
            case LoginRegister: status = SessionState.LoginRegisterConfirmed ; break ;
            case LoginRegisterConfirmed: status = SessionState.Booking ; break ;
            case Booking: status = SessionState.BookingConfirmed; break ;
            case BookingConfirmed: status = SessionState.Payment ; break ;
            case Payment:   status = SessionState.PaymentConfirmed ; break ;
            case PaymentConfirmed: status = SessionState.Final ; break ;
        }
        if ( sessionState == SessionState.Reset )
            status = SessionState.Final ;
        this.sessionState = status;
        System.out.println( this.sessionState ) ;
    }
    public void setVerifiedLogin(boolean verifiedLogin) { this.verifiedLogin = verifiedLogin; }
    public void setUserLoginName(String userLoginName) { this.userLoginName = userLoginName; }
    public boolean getVerifiedLogin() { return verifiedLogin; }

    public SessionState getSessionState() { return sessionState; }
    public boolean isVerifiedLogin() { return verifiedLogin; }

    public String getUserLoginName() { return userLoginName; }
}