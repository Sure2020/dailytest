package com.example.dailytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DailyTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyTestApplication.class, args);
		System.out.println("Say Hi");
	}

}
