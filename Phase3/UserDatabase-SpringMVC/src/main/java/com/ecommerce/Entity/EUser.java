package com.ecommerce.Entity;

public class EUser
{
    long    ID ;
    private String userName ;
    private String firstName ;
    private String lastName ;

    public long getID() { return ID ; }
    public String getUserName() { return userName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public void setID( long ID ) { this.ID = ID ; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
