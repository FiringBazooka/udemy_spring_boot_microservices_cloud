package com.udemy.microservice.APIGateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration  {
	
	@Bean
	public RouteLocator navigate(RouteLocatorBuilder builder) {
		
		Function<PredicateSpec, Buildable<Route>> routeFunction = p -> {
			return p.path("/currency-exchange/**").uri("lb://currency-exchange");
		};
		
		return builder.routes()
				.route(routeFunction)
				.route(p-> {
					return p.path("/currency-conversion/**").uri("lb://limits-service");
				})
				.route(p -> {
					return p.path("/get").filters(f->
						f.addRequestHeader("myHeader", "myHeaderValue")
						.addRequestParameter("myParam", "myParamValue"))
						.uri("http://httpbin.org:80/");
					
				})
				.build();
	}

}
