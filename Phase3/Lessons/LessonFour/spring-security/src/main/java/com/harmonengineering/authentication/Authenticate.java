/* *****************************************
 * File: Authenticate.java
 *  9/6/2022 B>S>H>
 *  12/24/2022 B>S>H> Added password encoder and matcher for authentication with BCrypt encoding
 */
package com.harmonengineering.authentication;

import com.harmonengineering.beans.User;
import com.harmonengineering.beans.UserData;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;


public class Authenticate
{
    private HashMap<String, User> m_Users ;
    private ArrayList<UserData> m_UsersData ;
    ValidatorBean m_validator ;

    private PasswordEncoder encoder ;
    public Authenticate()
    {
        m_Users = new HashMap<String,User>() ;
        m_UsersData = new ArrayList<UserData>() ;
        m_validator = new ValidatorBean() ;
    }

    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    private User findUser(User user )
    {
        // add lookup and return here
        return m_Users.get( user.getUserName() ) ;
    }
    private void addUser( User user )
    {
        //m_Users.put( user.getUserName(), new User( user.getUserName(), user.getUserPassword())) ;
        m_Users.put( user.getUserName(), user) ;

    }
    private AuthenticateResult ValidUserInput( User user, String confirmPassword )
    {
        AuthenticateResult result = ValidUserInput( user ) ;
        if ( result.getResultStatus() == AuthStatus.Validated &&
                !m_validator.isValidText( confirmPassword))
            result = new AuthenticateResult( AuthStatus.BadData_ConfirmationPassword, user ) ;
        return result ;
    }
    private AuthenticateResult ValidUserInput( User userInput )
    {
        AuthenticateResult result ;


        if ( !m_validator.isValidText( userInput.getUserName()  ) )
            result = new AuthenticateResult( AuthStatus.BadData_UserName, userInput ) ;
        else if(  !m_validator.isValidText( userInput.getUserPassword() ))
            result = new AuthenticateResult( AuthStatus.BadData_Password, userInput ) ;
        else result = new AuthenticateResult( AuthStatus.Validated, userInput ) ;
        return result ;

    }

    public AuthenticateResult AddUser( String userName, String userPassword, String confirmPassword ) {
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setUserPassword(userPassword);
        return AddUser( newUser, confirmPassword);
    }
    public AuthenticateResult AddUser( User newUser , String confirmPassword )
    {
        AuthenticateResult result = null ;

        if ( newUser == null )
            throw new RuntimeException( "AuthStatus:" +AuthStatus.NullUser.toString() ) ;

        result = ValidUserInput( newUser, confirmPassword ) ;
        if( result.getResultStatus() == AuthStatus.Validated )
        {
            if ( confirmPassword.equals( newUser.getUserPassword()))
            {
                if( (findUser( newUser ) == null) ) {
                    addUser(newUser);
                    result = new AuthenticateResult(AuthStatus.Authenticated, newUser);
                } else result = new AuthenticateResult( AuthStatus.UserAdd_UserExists, newUser ) ; // else handle error user exists
            } else result = new AuthenticateResult( AuthStatus.UserAdd_ConfirmationMismatch, newUser ) ;// else handle error password confirmation
        } // else result = new AuthenticateResult( AuthStatus.BadData_UserName , newUser ) ; // else handle data error
        return result ;
    }
    public void UpdateUserData( UserData data )
    {

    }
    public AuthenticateResult AuthenticateUser( String userName, String userPassword ) {
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setUserPassword(userPassword);
        return AuthenticateUser(newUser);
    }
    public AuthenticateResult AuthenticateUser( User newUser )
    {
        AuthenticateResult result = null ;

        if ( newUser == null )
            throw new RuntimeException( "AuthStatus:" + AuthStatus.NullUser.toString() ) ;

        result = ValidUserInput( newUser ) ;
        if ( result.getResultStatus() == AuthStatus.Validated )
        {
            User user = findUser( newUser) ;
            if ( user != null ) {
                if (newUser.getUserPassword().equals(user.getUserPassword()) ||
                    matchEncodedPasswords( newUser.getUserPassword(), user.getUserPassword())) {
                    // handle authenticate user
                    result = new AuthenticateResult(AuthStatus.Authenticated, user);
                } else result = new AuthenticateResult( AuthStatus.Authenticate_PasswordMismatch , newUser ) ;// else handle password mismatch
            } else result = new AuthenticateResult( AuthStatus.Authenticate_NoUser,  newUser ) ; // else handle authentication failure
        } // else result = new AuthenticateResult( AuthStatus.BadData_UserName , newUser ) ; // else handle data error
        return result ;
    }
    private boolean matchEncodedPasswords( String p1, String p2 )
    {
        System.out.println( "pw1:" + p1 ) ;
        System.out.println( "pw2:" + p2 ) ;
        return encoder.matches( p1, p2 ) ;
    }
}
