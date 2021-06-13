package com.spring.api.demo3.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.demo3.pojo.AuthenticationVO;
import com.spring.api.demo3.util.JwtTokenUtil;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateResource {

	@PostMapping
	public String authenticateUser(@RequestBody AuthenticationVO input) {

		// validate username and pwd using spring security

		// generate jwt token
		return new JwtTokenUtil().generate(input);

	}

	@GetMapping("/hello")
	public String getDetailsFromToken(@RequestHeader String token) {
		return new JwtTokenUtil().getUserName(token);
	}

}
