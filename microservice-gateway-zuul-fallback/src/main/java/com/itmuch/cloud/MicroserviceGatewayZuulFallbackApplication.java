package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceGatewayZuulFallbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayZuulFallbackApplication.class, args);
	}

	//创建/v1/microservice-provider-user/**的路由匹配规则
//	@Bean
//	public PatternServiceRouteMapper serviceRouteMapper() {
//		return new PatternServiceRouteMapper(
//				"(?<name>^.+)-(?<version>v.+$)",
//				"${version}/${name}");
//	}
}
