package com.harmonengineering;

public class EmployeeSalary
{
    private int ID ;
    private String  firstName ;
    private String  lastName ;
    private Double  Salary ;

    EmployeeSalary() {}

    public void setID(int ID) { this.ID = ID; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSalary(Double salary) { Salary = salary; }

    public int getID() { return ID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Double getSalary() { return Salary; }
}
