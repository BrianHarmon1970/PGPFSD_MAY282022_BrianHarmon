package com.ecommerce;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@Configuration
@SpringBootApplication
//@EnableZuulProxy
public class SpringEdgeApplication {
@Value ("application.properties" )
String str = "Hello" ;
    public static void main(String[] args) {
        SpringApplication.run(SpringEdgeApplication.class, args);
    }

}
