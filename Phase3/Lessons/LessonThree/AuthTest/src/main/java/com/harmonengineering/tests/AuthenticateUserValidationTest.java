/* *****************************************
 * File: AuthenticateUserValidationTest.java
 *  9/7/2022 B>S>H>
 */

package com.harmonengineering.tests;

import com.harmonengineering.authentication.AuthStatus;
import com.harmonengineering.authentication.Authenticate;
import com.harmonengineering.authentication.AuthenticateResult;
import com.harmonengineering.beans.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthenticateUserValidationTest
{
    Authenticate m_Authenticator ;
    AuthenticateResult m_Result ;
    AuthenticateUserValidationTest() { m_Authenticator = new Authenticate() ; }

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
    @DisplayName( "TCAUTH_01-AddUser - Test1 - normal strings")
    void AuthUserTest1() {
        m_Result  = m_Authenticator.AuthenticateUser( TestData.userName1, TestData.userPass1 );
        assert (m_Result.getResultStatus() == AuthStatus.Authenticate_NoUser );
    }
    @Test
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======

>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName( "TCAUTH_02-AddUser - Test1 - normal User")
    void AuthUserTest2()
    {
        User newUser = new User();
        newUser.setUserName( TestData.userName2 );
        newUser.setUserPassword( TestData.userPass2 );

        m_Result = m_Authenticator.AuthenticateUser( newUser ) ;
        assert ( m_Result.getResultStatus() == AuthStatus.Authenticate_NoUser ) ;
    }

    // username
    @Test
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======

>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName("TCAUTH_03-Invalid UserName (blank) ")
    void InvalidUsername1()
    {
        m_Result = m_Authenticator.AuthenticateUser( "", TestData.userPass1 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_UserName ) ;

    }
    @Test
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======

>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName("TCAUTH_04-Invalid UserName (null)")
    void InvalidUsername2()
    {
        m_Result = m_Authenticator.AuthenticateUser( null, TestData.userPass1 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_UserName ) ;
    }

    // password
    @Test
<<<<<<< HEAD
<<<<<<< HEAD


=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======


>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName("TCAUTH_05-Invalid Password (blank) ")
    void InvalidPassword1()
    {
        m_Result = m_Authenticator.AuthenticateUser( TestData.userName1, "" ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_Password ) ;
    }
    @Test
<<<<<<< HEAD
<<<<<<< HEAD


=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======


>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName("TCAUTH_06-Invalid Password (null)")
    void InvalidPassword2()
    {
        m_Result = m_Authenticator.AuthenticateUser( TestData.userName1, null  ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_Password ) ;
    }

    // All Bad Data
    @Test
<<<<<<< HEAD
<<<<<<< HEAD


=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======


>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName("TCAUTH_07-Invalid ALL (blank")
    void InvalidData1()
    {
        m_Result = m_Authenticator.AuthenticateUser( "", "" ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_ConfirmationPassword ||
                m_Result.getResultStatus() == AuthStatus.BadData_UserName ||
                m_Result.getResultStatus() == AuthStatus.BadData_Password) ;
    }
    @Test
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 67dc813 (Phase3 - Lesson 3 Project: Handling User Authentication. (AuthTest))
=======

>>>>>>> f93722c (Practice Project 3 - document only changes)
    @DisplayName("TCAUTH_08-Invalid ALL (null)")
    void InvalidData2()
    {
        m_Result = m_Authenticator.AuthenticateUser( null, null ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_ConfirmationPassword ||
                m_Result.getResultStatus() == AuthStatus.BadData_UserName ||
                m_Result.getResultStatus() == AuthStatus.BadData_Password) ;
    }
}
