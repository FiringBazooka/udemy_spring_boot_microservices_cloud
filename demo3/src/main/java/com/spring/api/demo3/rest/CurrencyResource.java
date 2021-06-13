package com.spring.api.demo3.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.api.demo3.configuration.FeignConfig;
import com.spring.api.demo3.pojo.CurrencyConversionVO;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyResource {

	@Autowired
	private FeignConfig feignConfig;

	@GetMapping("/{from}/to/{to}/{amount}")
	public CurrencyConversionVO retrieve(@PathVariable String from, @PathVariable String to, @PathVariable int amount) {

		HashMap<String, String> urlVariables = new HashMap<>();
		urlVariables.put("from", from);
		urlVariables.put("to", to);
		ResponseEntity<CurrencyConversionVO> vo = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/{from}/to/{to}", CurrencyConversionVO.class, urlVariables);

		vo.getBody().setAmount(amount);
		vo.getBody().setConvertedAmount(amount * (vo.getBody().getValue()));
		vo.getBody().setEnv(vo.getBody().getEnv() + " rest template");
		return vo.getBody();
	}

	@GetMapping("/feign/{from}/to/{to}/{amount}")
	public CurrencyConversionVO retrieveFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable int amount) {

		CurrencyConversionVO vo = feignConfig.retrieve(from, to);
		vo.setAmount(amount);
		vo.setConvertedAmount(amount * (vo.getValue()));
		vo.setEnv(vo.getEnv() + " feign");
		return vo;
	}
}
