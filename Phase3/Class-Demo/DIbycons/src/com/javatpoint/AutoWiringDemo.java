package com.javatpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringDemo {
	 
    public static void main(String a[]){
       
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        PaymentGateway paymentGateway = (PaymentGateway) context.getBean("paymentGateway");
        System.out.println(paymentGateway.toString());
    }
}
