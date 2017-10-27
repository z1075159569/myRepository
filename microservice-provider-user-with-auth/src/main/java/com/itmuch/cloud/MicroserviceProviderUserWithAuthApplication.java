package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceProviderUserWithAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProviderUserWithAuthApplication.class, args);
	}
}
