package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Entity.Employee;
import com.example.repository.EmployeeRepository;



public class EmployeeService 
{
	@Autowired
	EmployeeRepository employeeRepository ;
	
	//public Iterable<Employee> getAllEmployees()
	public String getAllEmployees()
	{

		///Optional<Employee> result =  ( employeeRepository).findAll() ;
		return "FindAll " ;
	}
	public String storeEmployee(Employee emp ) 
	{
		Optional<Employee> result = employeeRepository.findById( emp.getId()) ;
		if (result.isPresent())
		{
			return "Must be unique employee id." ;
		}
		else
		{
			employeeRepository.save(emp) ;
			return "Employee record saved success." ;
		}
	}

}
