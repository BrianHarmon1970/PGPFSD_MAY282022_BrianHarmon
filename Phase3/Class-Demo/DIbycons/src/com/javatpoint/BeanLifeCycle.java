package com.javatpoint;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class BeanLifeCycle {
 
    public static void main(String[] args) {
 
        // Reading configuration from the spring configuration file.
        ConfigurableApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");
 
        PersonBean myperson = context.getBean("personBean", PersonBean.class);
 
        System.out.println("Name= " + myperson.getName());
 
        // Closing the context object.
        context.close();
    }
}
