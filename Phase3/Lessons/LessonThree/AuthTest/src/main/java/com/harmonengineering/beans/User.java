/* *****************************************
 * File: User.java
 *  9/6/2022 B>S>H>
 */
package com.harmonengineering.beans;

public class User
{
    private int RecordKey ;
    private String userName ;
    private String userPassword ;

    public User( ) {}
    public User( String userName, String userPassword )
    {
        this.userName = userName ;
        this.userPassword = userPassword ;
    }
    public void setRecordKey(int recordKey) {  RecordKey = recordKey;  }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword;  }

    public int getRecordKey() { return RecordKey; }
    public String getUserName() { return userName; }
    public String getUserPassword() { return userPassword; }
}
