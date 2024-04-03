package com.springboot.demo.myspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.springboot.demo.myspringapp",
		"com.sprinboot.demo.myspringapp.config"})
public class MyspringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringappApplication.class, args);
	}

}
