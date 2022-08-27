package com.javatpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");
		
	   /* int status= dao.saveEmployee(new Employee(101,"Mohan",12000));
		System.out.println(status); */
		
	   /* int status1=dao.updateEmployee(new Employee(101,"Hello",8000));
		System.out.println(status1); */
		
		
		Employee e=new Employee();
		e.setId(101);
		int status1=dao.deleteEmployee(e);
	    System.out.println(status1);
		
	}

}
