package com.example.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Employee {
	
	@Id
	private Long id ;
	private String name ;
	private float salary ;

	public Employee() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	

}
