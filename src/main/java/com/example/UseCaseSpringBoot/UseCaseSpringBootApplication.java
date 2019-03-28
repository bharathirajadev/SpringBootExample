package com.example.UseCaseSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Select 1.5.19 version and download project from initilzr
//Step 1: Unzip the project 
//Step 2: File -> New -> Java Project -> Select the path - Finish
//Step 3: Right clickk -> Configure -> Convert to Maven Project
//Step 4: Run As -> Maven Clean -> Maven Install


@SpringBootApplication
public class UseCaseSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(UseCaseSpringBootApplication.class, args);
	}

}
