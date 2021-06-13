package com.spring.api.demo3.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.demo3.configuration.LimitsProperty;

@RestController
public class LimitsResource {

	@Autowired
	private LimitsProperty limitsProperty;

	@GetMapping("/limits")
	public LimitsProperty getValue() {
		return limitsProperty;
	}

}
