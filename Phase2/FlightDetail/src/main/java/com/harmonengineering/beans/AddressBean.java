package com.harmonengineering.beans;

public class AddressBean
{
    private int ID ;
    private String street1 ;
    private String street2 ;
    private String  City ;
    private String State ;
    private String zipCode ;

    public AddressBean() {}

    public void setID(int ID) { this.ID = ID; }
    public void setStreet1(String street1) { this.street1 = street1; }
    public void setStreet2(String street2) { this.street2 = street2; }
    public void setCity(String city) { City = city; }
    public void setState(String state) { State = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public int getID() { return ID; }
    public String getStreet1() { return street1; }
    public String getStreet2() { return street2; }
    public String getCity() { return City; }
    public String getState() { return State; }
    public String getZipCode() { return zipCode; }
}
