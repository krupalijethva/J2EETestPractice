package com.example.employeeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan({"com.example"})
@SpringBootApplication
public class EmployeeAppApplication {

	public static void main(String[] args) {
		System.out.println("in spring..");
		SpringApplication.run(EmployeeAppApplication.class, args);
	}
}
