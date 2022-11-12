package com.service;
//import java.util.ArrayList ;
/*
public class EmployeeService {
	Employee getEmploy( int id )
	{
		emp = new Employee( 100, "John", "Tester", 40000 ) ;
		return emp ;
	}
	List<Employee> getAllEmployees()
	{
		ArrayList<Employee> empList = new ArrayList<Employee>() ;
		empList.add( new Employee( 100, "John", "Tester", 40000 )) ;
		empList.add( new Employee( 100, "Jack", "Programmer", 50000 )) ;
		empList.add( new Employee( 100, "Joe", "Manager", 60000 )) ;
		
		
	}
	double updateSalary( Employee emp )
	{
		if( emp.getPosition().equals( "Tester" )
				return emp.getSalary() + 2000 ;
		else if ( emp.getPostion().equals( "Programmer" )) 
			return emp.getSalary() + 4000 ;
		else if ( emp.getPosition().equals( "Manager" )) 
			return emp.getSalary() + 6000 ;
		 
		
	}

}*/



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bean.Employee;

public class EmployeeService {
	List<Employee> listOfEmp;
	public EmployeeService() {
		listOfEmp= new ArrayList<Employee>();
		listOfEmp.add(new Employee(1, "Ajay", 14000, "Tester"));
		listOfEmp.add(new Employee(2, "Vijay", 16000, "Programmer"));
		listOfEmp.add(new Employee(3, "Lokesh", 18000, "Manager"));
	}
	public Employee getEmployee() {
		// coding....
		Employee emp = new Employee(100, "Ravi", 12000, "Tester");
		return emp;
	}
	public List<Employee> getAllEmployee() {
		return listOfEmp;
	}
	public double updateSalary(Employee emp) {
		if(emp.getPosition().equals("Manager")) {
			return emp.getSalary()+5000;
		}else if(emp.getPosition().equals("Programmer")) {
			return emp.getSalary()+3000;
		}else {
			return emp.getSalary()+1000;
		}
	}
	public Employee searchEmployee(int id) {
		return listOfEmp.stream().filter(emp->emp.getId()==id).findFirst().get();
		// if record presnet it return employee object else it return null.
	}
	
	public String removeEmployee(int id) {
		Employee employee  = listOfEmp.stream().filter(emp->emp.getId()==id).findFirst().get();
		if(employee==null) {
			return "Record not present";
		}else {
			listOfEmp.remove(employee);
			return "Record removed successfully";
		}
	}
}
