package com.example.dailytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableScheduling
@EnableOpenApi
public class DailyTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyTestApplication.class, args);
		System.out.println("Say Hi");
	}

}
