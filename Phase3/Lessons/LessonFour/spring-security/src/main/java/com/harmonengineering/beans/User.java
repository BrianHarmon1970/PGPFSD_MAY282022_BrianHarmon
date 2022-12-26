/* *****************************************
 * File: User.java
 *  9/6/2022 B>S>H>
 *  12/24/2022 B>S>H> added authorities as a simple string array
 */
package com.harmonengineering.beans;

import java.util.ArrayList;

public class User
{
    private int RecordKey ;
    private String userName ;
    private String userPassword ;

    private ArrayList<String> authorities ;

    public User( ) { this.authorities = new ArrayList<String>() ;}
    public User( String userName, String userPassword )
    {
        this.userName = userName ;
        this.userPassword = userPassword ;
        this.authorities = new ArrayList<String>() ;
    }
    public void GrantUserAuthorities( ArrayList<String> newAuthorities )
    {
        authorities.addAll(newAuthorities) ;
    }
    public ArrayList<String> getUserAuthorities() { return authorities ; }
    public void setRecordKey(int recordKey) {  RecordKey = recordKey;  }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword;  }

    public int getRecordKey() { return RecordKey; }
    public String getUserName() { return userName; }
    public String getUserPassword() { return userPassword; }
}
