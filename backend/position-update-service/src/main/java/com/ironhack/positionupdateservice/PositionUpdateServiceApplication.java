package com.ironhack.positionupdateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PositionUpdateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionUpdateServiceApplication.class, args);
	}

}
