package com.spring.api.demo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.api.demo3.dao.UsersDao;
import com.spring.api.demo3.pojo.User;

@Service
public class UsersService {

	@Autowired
	private UsersDao dao;

	public List<User> getAllUsers() {
		return dao.findAll();

	}

	public Page<User> getAllPageableUsers(Pageable page) {
		return dao.findAll(page);

	}

	public void addUser(User user) {
		dao.save(user);
	}

	public Optional<User> getUser(int id) {
		return dao.findById(id);
	}

	public void deleteUser(int id) {
		dao.deleteById(id);
	}

	public void deleteMultipleUsers(List<Integer> empNo) {
		dao.deleteByEmpNoIn(empNo);
	}

	public User updateUser(User user) {
		return dao.save(user);
	}

}
