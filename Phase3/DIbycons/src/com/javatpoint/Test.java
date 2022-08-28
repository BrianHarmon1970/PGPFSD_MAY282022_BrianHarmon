package com.javatpoint;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.*;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Resource r=new ClassPathResource("applicationContext.xml");  //1st step call xml file
		BeanFactory factory=new XmlBeanFactory(r);  // 2nd step IoC container object
		
		Employee s=(Employee) factory.getBean("e");  // 3rd Step is creating Employee object
		s.show();  // custom java method
		
	}
}
