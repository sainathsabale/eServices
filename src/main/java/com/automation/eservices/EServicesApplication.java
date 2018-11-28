package com.automation.eservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EServicesApplication.class, args);
	}
}
