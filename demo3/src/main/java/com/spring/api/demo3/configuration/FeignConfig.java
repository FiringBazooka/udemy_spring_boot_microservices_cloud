package com.spring.api.demo3.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.api.demo3.pojo.CurrencyConversionVO;

//@FeignClient(name = "currency-exchange", url = "http://localhost:8001")
@FeignClient(name = "currency-exchange")
public interface FeignConfig {

	@GetMapping("/currency-exchange/{from}/to/{to}")
	public CurrencyConversionVO retrieve(@PathVariable String from, @PathVariable String to);

}
