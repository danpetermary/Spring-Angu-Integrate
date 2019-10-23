package com.stackroute.cgiauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.stackroute.cgiauth")
@SpringBootApplication
public class CgiAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgiAuthenticationApplication.class, args);
	}

}
