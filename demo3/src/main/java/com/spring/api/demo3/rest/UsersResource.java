package com.spring.api.demo3.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.api.demo3.exception.EmployeeNotFoundException;
import com.spring.api.demo3.pojo.User;
import com.spring.api.demo3.service.UsersService;

@RestController
@RequestMapping("/employee")
public class UsersResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsersResource.class);

	@Autowired
	private UsersService service;

	@Autowired
	private ResourceBundleMessageSource messageSource;

	@GetMapping("/list")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/list/paging")
	public Page<User> getPageableEmpList(Pageable page) {
		return service.getAllPageableUsers(page);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		Optional<User> userInfo = service.getUser(user.getEmpNo());
		if (userInfo.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee is ALREADY onboarded!");
		}
		service.addUser(user);
		LOGGER.info("Employee " + user.getEmpNo() + " onboarded!");

		return new ResponseEntity<Object>(user, HttpStatus.CREATED);

	}

	@GetMapping("/{empNo}")
	public User getUser(@PathVariable int empNo) throws Exception {
		Optional<User> userInfo = service.getUser(empNo);
		if (userInfo.isPresent()) {
			return userInfo.get();
		} else {
			// throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee details do
			// not exist!");
			throw new EmployeeNotFoundException("Employee details do not exist!");
		}
	}

	@DeleteMapping("/{empNo}/delete")
	public void deleteUser(@PathVariable int empNo) throws Exception {
		getUser(empNo);
		service.deleteUser(empNo);

	}

	@DeleteMapping("/delete")
	public void deleteMultipleUsers(@RequestBody List<Integer> empNoList) {
		service.deleteMultipleUsers(empNoList);
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) throws Exception {
		getUser(user.getEmpNo());
		return service.updateUser(user);
	}

	@GetMapping("/internationalization")
	public String language() {
		return messageSource.getMessage("my.location", null, LocaleContextHolder.getLocale());
	}

}
