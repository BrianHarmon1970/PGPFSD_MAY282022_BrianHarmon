package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.example.Entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService ;
	
	@PostMapping( value="storeEmployee" , consumes = MediaType.APPLICATION_JSON_VALUE )
	public String storeEmployee( @RequestBody Employee employee )
	{
		return employeeService.storeEmployee(employee) ;
	}
	@GetMapping( value="all" )
	// public Iterable<Employee> retrieveEmployee()
	public String retrieveEmployee()
	{
		return employeeService.getAllEmployees() ;
	}
}
