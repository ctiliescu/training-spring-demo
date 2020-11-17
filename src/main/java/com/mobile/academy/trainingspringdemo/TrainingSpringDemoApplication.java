package com.mobile.academy.trainingspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingSpringDemoApplication {

	public static void main(String[] args) {
		// pentru swagger ui accesati http://localhost:8181/swagger-ui
		SpringApplication.run(TrainingSpringDemoApplication.class, args);
	}

}
