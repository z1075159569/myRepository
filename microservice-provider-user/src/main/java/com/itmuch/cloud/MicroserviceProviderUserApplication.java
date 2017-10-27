package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProviderUserApplication.class, args);
	}

}
