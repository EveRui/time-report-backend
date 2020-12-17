package com.gev.gateway;

import com.gev.gateway.filter.AuthGatewayFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	//try
//	@Bean
//	public RouteLocator routeLocator(RouteLocatorBuilder builder){
//		return builder.routes()
//				.route(r -> r.path("/timesheet/**")
//				.filters(f -> f.stripPrefix(1)
//						.filter(new AuthGatewayFilter()))
//				.uri("localhost:22222"))
//				.build();
//	}

	//--------

}
