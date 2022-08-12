package com.harmonengineering;

public class EmployeeCertificate
{
    private int ID ;
    private String  description ;
    private int     employeeID ;

    EmployeeCertificate() {}
    public void setID(int ID) { this.ID = ID;}
    public void setDescription(String description) { this.description = description; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public String getDescription() { return description; }
    public int getEmployeeID() { return employeeID; }
    public int getID() { return ID; }
}
