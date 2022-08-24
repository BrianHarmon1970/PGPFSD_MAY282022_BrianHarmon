package com.harmonengineering.beans;

import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class UserBean
{
    private String  ID ;
    private String  userName ;
    private String  userPass ;
    private String  userType ;

    public UserBean() {} ;

    public void setID(String ID) { this.ID = ID; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserPass(String userPass) {this.userPass = userPass; }
    public void setUserType(String userType) { this.userType = userType; }

    public String getID() { return ID; }
    public String getUserName() { return userName; }
    public String getUserPass() { return userPass; }
    public String getUserType() { return userType; }

    public void sprint(JspWriter out) throws IOException
    {
        out.println( "<br>ID{" + ID +"}, " +
                        " userName{" + userName + "} , userPass{" + userPass + "}, " +
                        " userType{" + userType + "}.") ;

    }
}
