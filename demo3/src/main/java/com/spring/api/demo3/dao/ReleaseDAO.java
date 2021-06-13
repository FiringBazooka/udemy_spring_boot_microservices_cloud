package com.spring.api.demo3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.api.demo3.pojo.Releases;

@Repository
public interface ReleaseDAO extends JpaRepository<Releases, String> {

}
