/* *****************************************
 * File: TestData.java
 *  9/7/2022 B>S>H>
 */

package com.harmonengineering.tests;

import com.harmonengineering.beans.User;

public class TestData
{
    public static final String userName1 = "newuser1@new.com" ;
    public static String userPass1 = "newuserpass1";
    public static final User User1 = new User( userName1, userPass1 ) ;

    public static final String userName2 = "newuser2@new.com" ;
    public static final String userPass2 = "userpass2" ;
    public static User User2 = new User( userName2, userPass2 ) ;

    public static final String userName3 = "newuser3@new.com" ;
    public static final String userPass3 = "userPass3" ;
    public static User User3 = new User( userName3, userPass3 ) ;

    public static final String userName4 = "newuser4@new.com" ;
    public static String userPass4 = "newuserpass4";
    public static final User User4 = new User( userName4, userPass4 ) ;

    public static final String unAuthorizedUserName = "unAuthorized@fake.com";
    public static final String unAuthorizedUserPass = "unAuthorizedPassword" ;
    public static final User     unAuthorizedUser  = new User( unAuthorizedUserName, unAuthorizedUserPass ) ;
    public static final String wrongPassword = "FatFingers" ;
}
