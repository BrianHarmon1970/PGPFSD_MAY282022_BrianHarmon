package com.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.bean.Employee;

public class EmployeeServiceTest {

  @Test
  //@Ignore
  public void getAllEmployeeTest() {
	  EmployeeService es = new EmployeeService();
	  List<Employee> listOfEmp = es.getAllEmployee();
	  assertEquals(listOfEmp.size(), 3);
	  Employee emp = listOfEmp.get(1);
	  	assertEquals(emp.getId(), 2);
  		assertEquals(emp.getName(), "Vijay");
  		assertEquals(emp.getSalary(), 16000);
  		assertEquals(emp.getPosition(), "Programmer");
  }

  @Test
  //@Ignore
  public void getEmployeeTest() {
    EmployeeService es = new EmployeeService();
    	Employee emp = es.getEmployee();
    	//Assert.assertEquals(false, null);
    	assertNotNull(emp);
    	assertEquals(emp.getId(), 100);
    	assertEquals(emp.getName(), "Ravi");
    	assertEquals(emp.getSalary(), 12000);
    	assertEquals(emp.getPosition(), "Tester");
  }

  @Test
  public void removeEmployeeTest() {
    //throw new RuntimeException("Test not implemented");
	  EmployeeService es = new EmployeeService();
	  List<Employee> listOfEmp = es.getAllEmployee();
	  assertEquals(listOfEmp.size(), 3);
	  	es.removeEmployee(2);
	  List<Employee> listOfEmp1 = es.getAllEmployee();
	  assertEquals(listOfEmp1.size(), 2);
  }

  @Test
  //@Ignore
  public void searchEmployeeTest() {
	  EmployeeService es = new EmployeeService();
	  Employee emp1	 = es.searchEmployee(100);
	  Employee emp2 =  es.searchEmployee(2);
	  assertNull(emp1);
	  assertNotNull(emp2);
  }

  @Test
  //@Ignore
  public void updateSalaryTest() {
	  EmployeeService es = new EmployeeService();
	  Employee emp = new Employee(1, "Ravi", 45000, "Programmer");
	  double updatedSalary = es.updateSalary(emp);
	  assertEquals(updatedSalary, emp.getSalary()+3000);
  }
}