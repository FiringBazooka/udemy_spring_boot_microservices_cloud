package com.spring.api.demo3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.api.demo3.pojo.User;

@Repository
public interface UsersDao extends JpaRepository<User, Integer> {

	@Transactional
	public void deleteByEmpNoIn(List<Integer> empNo);

}
