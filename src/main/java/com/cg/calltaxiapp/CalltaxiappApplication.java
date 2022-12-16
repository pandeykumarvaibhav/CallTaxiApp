package com.cg.calltaxiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cg.calltaxiapp")
public class CalltaxiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalltaxiappApplication.class, args);
	}

}
