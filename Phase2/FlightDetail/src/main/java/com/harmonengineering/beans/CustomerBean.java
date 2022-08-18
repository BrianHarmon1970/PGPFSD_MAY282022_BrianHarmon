package com.harmonengineering.beans;

public class CustomerBean
{
    private int ID ;
    private String firstName ;
    private String lastName ;
    private String phoneNumber ;
    private String emailAddress ;
    private int user_id ;

    public CustomerBean() {}

    public void setID(int ID) { this.ID = ID; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public int getID() { return ID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmailAddress() { return emailAddress; }
    public int getUser_id() { return user_id; }
}
