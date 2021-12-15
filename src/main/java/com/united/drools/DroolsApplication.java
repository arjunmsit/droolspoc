package com.united.drools;

import com.united.drools.utilities.PreChecks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DroolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolsApplication.class, args);
		System.out.println("Spring boot drools started...");
	}

}
