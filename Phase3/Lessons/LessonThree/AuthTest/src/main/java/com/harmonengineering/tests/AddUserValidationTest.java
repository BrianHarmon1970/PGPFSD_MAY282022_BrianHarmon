/* *****************************************
 * File: AddUserValidationTest.java
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

import static org.junit.jupiter.api.Assertions.assertSame;

class AddUserValidationTest
{
    Authenticate m_Authenticator ;
    AuthenticateResult m_Result ;
    AddUserValidationTest() { m_Authenticator = new Authenticate() ; }
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
    @DisplayName( "TCADD_01-AddUser - Test1 - normal strings")
    void AddUserTest1() {
        m_Result  = m_Authenticator.AddUser( TestData.userName1, TestData.userPass1, TestData.userPass1 );
        assert (m_Result.getResultStatus() == AuthStatus.Authenticated);
    }
    @Test
    @DisplayName( "TCADD_02-AddUser - Test1 - normal User")
    void AddUserTest2()
    {
        //AuthenticateResult result ;

        User newUser = new User();
        newUser.setUserName( TestData.userName2 );
        newUser.setUserPassword( TestData.userPass2 );

        m_Result = m_Authenticator.AddUser( newUser, TestData.userPass2 ) ;
        assert ( m_Result.getResultStatus() == AuthStatus.Authenticated ) ;
    }

    // username
    @Test
    @DisplayName("TCADD_03-Invalid UserName (blank) ")
    void InvalidUsername1()
    {
        m_Result = m_Authenticator.AddUser( "", TestData.userPass1, TestData.userPass1 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_UserName ) ;
    }
    @Test
    @DisplayName("TCADD_04-Invalid UserName (null)")
    void InvalidUsername2()
    {
        m_Result = m_Authenticator.AddUser( null, TestData.userPass1, TestData.userPass1 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_UserName ) ;
    }

    // password
    @Test
    @DisplayName("TCADD_05-Invalid Password (blank) ")
    void InvalidPassword1()
    {
        m_Result = m_Authenticator.AddUser( TestData.userName1, "", TestData.userPass1 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_Password ) ;
    }
    @Test
    @DisplayName("TCADD_06-Invalid Password (null)")
    void InvalidPassword2()
    {
        m_Result = m_Authenticator.AddUser( TestData.userName1, null, TestData.userPass1 ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_Password ) ;
    }

    // confirmation password
    @Test
    @DisplayName("TCADD_07-Invalid ConfirmPassword (blank) ")
    void InvalidConfirmPassword1()
    {
        m_Result = m_Authenticator.AddUser( TestData.userName1, TestData.userPass1, "" ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_ConfirmationPassword ) ;
    }
    @Test
    @DisplayName("TCADD_08-Invalid ConfirmPassword (null)")
    void InvalidConfirmPassword2()
    {
        m_Result = m_Authenticator.AddUser( TestData.userName1, TestData.userPass1, null ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_ConfirmationPassword ) ;
    }

    // All Bad Data
    @Test
    @DisplayName("TCADD_09-Invalid ALL (blank")
    void InvalidData1()
    {
        m_Result = m_Authenticator.AddUser( "", "", "" ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_ConfirmationPassword ||
                m_Result.getResultStatus() == AuthStatus.BadData_UserName ||
                m_Result.getResultStatus() == AuthStatus.BadData_Password) ;
    }
    @Test
    @DisplayName("TCADD_10-Invalid ALL (null)")
    void InvalidData2()
    {
        m_Result = m_Authenticator.AddUser( null, null, null ) ;
        assert( m_Result.getResultStatus() == AuthStatus.BadData_ConfirmationPassword ||
                m_Result.getResultStatus() == AuthStatus.BadData_UserName ||
                m_Result.getResultStatus() == AuthStatus.BadData_Password) ;
    }
}
