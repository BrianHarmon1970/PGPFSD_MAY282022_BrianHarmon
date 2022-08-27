package com.harmonengineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "com.harmonengineering")
public class SportyShoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyShoesApplication.class, args);
	}
=======

@SpringBootApplication
public class SportyShoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportyShoesApplication.class, args);
    }
>>>>>>> 9aa460f ((rebase Phase3) beginning Phase3-ending Phase2 branch on 2 and 3. synch.)

}
