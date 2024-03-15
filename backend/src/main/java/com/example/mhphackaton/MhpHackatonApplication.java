package com.example.mhphackaton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@EntityScan(basePackages = "com.example.mhphackaton")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MhpHackatonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MhpHackatonApplication.class, args);
	}

}
