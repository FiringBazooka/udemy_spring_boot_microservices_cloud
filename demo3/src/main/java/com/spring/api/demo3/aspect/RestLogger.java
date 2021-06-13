package com.spring.api.demo3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.api.demo3.LogOutput;
import com.spring.api.demo3.pojo.Releases;

@Aspect
@Component
public class RestLogger {
	
	Logger logger = LoggerFactory.getLogger(RestLogger.class);
	
	@Before("execution(* addARelease(*))")
	public void inputLog(JoinPoint jp) {
		logger.info(" RELEASE IS ADDED for {}",jp); 
		
	}

	@AfterReturning(value="@annotation(logOutput)",returning="result")
	public void logInput(JoinPoint jp, Object result, LogOutput logOutput) {
		Releases output = (Releases) result;
		logger.info(" AFTER RETURNING RELEASE IS ADDED for {} --> {}",jp,output.getName()); 
		logger.info("JP methods -> {},{},{},{}",jp.getSignature(),jp.getArgs(),jp.getTarget().getClass(),jp.getStaticPart());
		
	}
}
