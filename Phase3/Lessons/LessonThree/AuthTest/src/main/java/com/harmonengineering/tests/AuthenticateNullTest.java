/* *****************************************
 * File: AuthenticateNullTest.java
 *  9/7/2022 B>S>H>
 */

package com.harmonengineering.tests;

import com.harmonengineering.authentication.AuthStatus;
import com.harmonengineering.authentication.Authenticate;
import com.harmonengineering.authentication.AuthenticateResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthenticateNullTest {
    Authenticate m_Authenticator;
    AuthenticateResult m_Result;

    AuthenticateNullTest() {
        m_Authenticator = new Authenticate();
    }

    @BeforeEach
    void Reset() {
        m_Result = null;
    }

    @AfterEach
    void TestNullResult() {
    //    assert (m_Result != null); // Testing for null explicitly so excluding this test
    }
    @Test
    @DisplayName( " ADD NULL USER EXCEPTION")
    void AddNullUserTest()
    {

        assertThrows( RuntimeException.class, () ->
        { m_Result = m_Authenticator.AddUser( null , TestData.userPass1 ) ; } ) ;

    }

    @Test
    @DisplayName( " AUTH NULL USER EXCEPTION ")
    void AuthenticateNullUserTest()
    {
        assertThrows( RuntimeException.class, () ->
        { m_Result =  m_Authenticator.AuthenticateUser( null  ) ; }) ;
    }
    @Test
    @DisplayName( " ADD USER NULL RESULT")
    void AddUserNullResultTest()
    {
        try {
            m_Result = m_Authenticator.AddUser(null, TestData.userPass1);
            assert (m_Result.getResultStatus() == AuthStatus.Authenticated);
        } catch ( RuntimeException e ) { }
        assert ( m_Result == null ) ;
    }

    @Test
    @DisplayName( " AUTH USER NULL RESULT")
    void AuthenticateNullResultTest()
    {
        try {
            m_Result = m_Authenticator.AuthenticateUser(null);
            assert (m_Result.getResultStatus() == AuthStatus.Authenticated);
        } catch ( RuntimeException e ) {}
        assert ( m_Result == null ) ;
    }

}
