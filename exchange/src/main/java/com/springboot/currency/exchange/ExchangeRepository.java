package com.springboot.currency.exchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeVO, Long> {

	ExchangeVO findByFromAndTo(String from, String to);

}
