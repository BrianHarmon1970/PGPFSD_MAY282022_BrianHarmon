package com.example.DockerSpringMySQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@EntityScan(basePackages = "com.Entity" )
@EnableJpaRepositories(basePackages = "com.example.repository" )
public class DockerSpringMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerSpringMySqlApplication.class, args);
		System.out.println( "Server is up " ) ;
	}

}
