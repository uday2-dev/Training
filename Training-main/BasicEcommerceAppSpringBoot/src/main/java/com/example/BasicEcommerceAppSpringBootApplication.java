package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.example.entities")

public class BasicEcommerceAppSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicEcommerceAppSpringBootApplication.class, args);
	}

}
