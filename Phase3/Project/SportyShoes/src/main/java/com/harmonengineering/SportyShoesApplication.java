package com.harmonengineering;

import org.apache.logging.log4j.util.BiConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;


@EnableJpaRepositories
//@EnableWebMvc
@SpringBootApplication(scanBasePackages = "com.harmonengineering")
public class SportyShoesApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SportyShoesApplication.class, args);
		System.out.println( "SERVICE UP") ;
		System.out.println( "CLASSPATH: " + System.getProperty("java.class.path")) ;
		System.out.println( "JAVAHOME: " + System.getProperty("java.home")) ;
		printenv();
	}
	public static void printenv()
	{
		Map<String,String> itemList = System.getenv() ;
		Iterator<Map.Entry<String, String>> entryIterator = itemList.entrySet().iterator() ;
		while ( entryIterator.hasNext() )
		{
			Map.Entry<String,String> item = entryIterator.next() ;
			System.out.println( "${ " + item.getKey() + " } == " + item.getValue() );
		}
	}

}
