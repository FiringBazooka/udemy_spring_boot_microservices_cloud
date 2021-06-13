package com.spring.api.demo3.exception;

public class EmployeeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3864647115754964617L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
