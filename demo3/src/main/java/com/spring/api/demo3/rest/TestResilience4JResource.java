package com.spring.api.demo3.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class TestResilience4JResource {

	private Logger logger = LoggerFactory.getLogger(TestResilience4JResource.class);
	
	@GetMapping("/resilience4j/retry")
	@Retry(name = "test", fallbackMethod = "fallbackResponse")
	public String test() {
		logger.info("<<<< resilience 4J TEST API called >>>> ");
		ResponseEntity<String> response =  new RestTemplate().getForEntity("http://localhost:10000/dummy", String.class);
		return response.getBody();
	}
	
	private String fallbackResponse(Exception e) {
		return "resilience 4j fallback response";
	}
	
	
	@GetMapping("/resilience4j/circuitbreaker")
	@CircuitBreaker(name = "test1", fallbackMethod = "fallbackResponse")
	public String test1() {
		logger.info("<<<< resilience 4J TEST1 API called >>>> ");
		ResponseEntity<String> response =  new RestTemplate().getForEntity("http://localhost:10000/dummy", String.class);
		return response.getBody();
	}
	
	@GetMapping("/resilience4j/rateLimiter")
	@RateLimiter(name = "test2")
	public String test2() {
		logger.info("<<<< resilience 4J TEST2 API called >>>> ");
		return "rateLimiter API response";
	}
	
	
}
