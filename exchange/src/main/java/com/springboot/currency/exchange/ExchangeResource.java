package com.springboot.currency.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class ExchangeResource {

	@Autowired
	private ExchangeRepository repository;

	@Autowired
	private Environment env;

	@GetMapping("/{from}/to/{to}")
	public ExchangeVO retreive(@PathVariable String from, @PathVariable String to) {

		// return new ExchangeVO(1L, "AUD", "IND", 60, "8000");
		ExchangeVO vo = repository.findByFromAndTo(from, to);
		vo.setEnv(env.getProperty("server.port"));
		return vo;

	}
}
