package com.javatpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireConstruct {

	public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	      TextEditor te = (TextEditor) context.getBean("textEditor");
	      te.spellCheck();
	   }
}
