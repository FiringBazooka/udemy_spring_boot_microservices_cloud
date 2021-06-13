package com.spring.api.demo3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.api.demo3.pojo.ExceptionVO;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionVO mapException(EmployeeNotFoundException e) {

		ExceptionVO vo = new ExceptionVO();
		vo.setErrorMessage(e.getMessage());
		vo.setErrorCode(10077);
		return vo;
	}

	public void test() {
		System.out.println("<<<<< controller advice >>>> ");
	}
}
