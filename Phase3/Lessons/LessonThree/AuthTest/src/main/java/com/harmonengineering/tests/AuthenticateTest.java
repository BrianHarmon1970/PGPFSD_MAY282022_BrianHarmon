/* *****************************************
 * File: AuthenticateTest.java
 *  9/7/2022 B>S>H>
 */

package com.harmonengineering.tests;

import com.harmonengineering.authentication.AuthStatus;
import com.harmonengineering.authentication.Authenticate;
import com.harmonengineering.authentication.AuthenticateResult;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticateTest
{
    Authenticate m_Authenticator ;
    AuthenticateResult m_Result ;

    AuthenticateTest() { m_Authenticator = new Authenticate() ; }
    @BeforeEach
    void Reset()
    {
        m_Result = null ;
    }
    @AfterEach
    void TestNullResult()
    {
        assert( m_Result != null ) ;
    }
    @Test
    @DisplayName( "Confirmed Password mismatch" )
    void ConfirmMismatch()
    {
        m_Result = m_Authenticator.AddUser( TestData.userName1, TestData.userPass1 , TestData.userPass2 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.UserAdd_ConfirmationMismatch ) ;
    }
    @Test
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======

>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName( " ADD USER ")
    void AddUserTest()
    {
        m_Result = m_Authenticator.AddUser( TestData.userName1, TestData.userPass1 , TestData.userPass1 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.Authenticated ) ;
    }
    @Test
    @DisplayName( "2X AddUser")
    void AddUserTwice()
    {
        m_Authenticator.AddUser( "newuser2@new.com", "password", "password" ) ;
        m_Result = m_Authenticator.AddUser( "newuser2@new.com", "password", "password" ) ;
        assertSame(m_Result.getResultStatus(), AuthStatus.UserAdd_UserExists);
    }
    @Test
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======

>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName( " AUTH USER ")
    void AuthUserTest()
    {

        m_Result = m_Authenticator.AddUser( TestData.User3, TestData.userPass3 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.Authenticated ) ;
        m_Result = m_Authenticator.AuthenticateUser( TestData.User3 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.Authenticated ) ;
    }
    @Test
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======

>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName( " DENY USER ")
    void DenyUserTest()
    {
        m_Result = m_Authenticator.AuthenticateUser( TestData.unAuthorizedUser ) ;
        assert( m_Result.getResultStatus() == AuthStatus.Authenticate_NoUser ) ;
    }
    @Test
<<<<<<< HEAD
<<<<<<< HEAD



=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======



>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName( " BAD PASSWORD ")
    void AuthUserBadPassTest()
    {

        m_Result = m_Authenticator.AddUser( TestData.User4, TestData.userPass4 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.Authenticated ) ;
        TestData.User4.setUserPassword( TestData.wrongPassword);
        m_Result = m_Authenticator.AuthenticateUser( TestData.User4 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.Authenticate_PasswordMismatch ) ;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======


>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======
>>>>>>> f93722c (Practice Project 3 - document only changes)
}
