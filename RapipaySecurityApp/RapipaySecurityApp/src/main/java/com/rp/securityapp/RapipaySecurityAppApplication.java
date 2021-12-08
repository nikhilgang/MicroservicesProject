package com.rp.securityapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class RapipaySecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RapipaySecurityAppApplication.class, args);
	}

}
