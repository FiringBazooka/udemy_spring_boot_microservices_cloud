package com.spring.api.demo3.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.spring.api.demo3.pojo.AuthenticationVO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
@PropertySource("classpath:application.properties")
public class JwtTokenUtil {

	@Value("${server.port}")
	private String jwtSecret;

	@Autowired
	private Environment env;

	public String generate(AuthenticationVO input) {
		Map<String, Object> claims = new HashMap<String, Object>();
		System.out.println("<<<< secret " + jwtSecret);
		// System.out.println("<<<< secret " + env.getProperty("jwt.secret"));
		return Jwts.builder().addClaims(claims).setSubject(input.getUsername())
				.signWith(SignatureAlgorithm.HS512, "something").compact();

	}

	public String getUserName(String token) {

		return Jwts.parser().setSigningKey("something").parseClaimsJws(token).getBody().getSubject();
	}

}
