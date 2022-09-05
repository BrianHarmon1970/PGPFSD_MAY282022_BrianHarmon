package com.javatpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InheritanceSpring {
 
	public static void main(String[] args) {
	
	  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	  
      WorldClass wc = (WorldClass) context.getBean("worldClass");
      wc.getMessage1();
      wc.getMessage2();

      IndiaClass ic = (IndiaClass) context.getBean("indiaClass");
      ic.getMessage1();
      ic.getMessage2();
      ic.getMessage3(); 
	} 
}
