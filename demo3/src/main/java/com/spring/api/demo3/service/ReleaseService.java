package com.spring.api.demo3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.demo3.dao.ReleaseDAO;
import com.spring.api.demo3.pojo.Releases;

@Service
public class ReleaseService {

	@Autowired
	private ReleaseDAO dao;

	public List<Releases> getAllReleasesDetails() {
		return dao.findAll();
	}

	public Releases saveARelease(Releases input) {
		return dao.save(input);
	}

}
