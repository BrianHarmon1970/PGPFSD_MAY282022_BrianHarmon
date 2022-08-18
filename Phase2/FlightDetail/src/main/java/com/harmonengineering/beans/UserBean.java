package com.harmonengineering.beans;

public class UserBean
{
    private int     ID ;
    private String  userName ;
    private String  userPass ;
    private String  userType ;

    public UserBean() {} ;

    public void setID(int ID) { this.ID = ID; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserPass(String userPass) {this.userPass = userPass; }
    public void setUserType(String userType) { this.userType = userType; }

    public int getID() { return ID; }
    public String getUserName() { return userName; }
    public String getUserPass() { return userPass; }
    public String getUserType() { return userType; }

}
