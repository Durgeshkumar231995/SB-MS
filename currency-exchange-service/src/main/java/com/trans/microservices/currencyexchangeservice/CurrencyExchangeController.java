package com.trans.microservices.currencyexchangeservice;

//import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	@Autowired
	CurrencyValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	// http://localhost:8000/currency-exchange/from/USD/to/INR
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
	
//		ExchangeValue exchangeValue=new ExchangeValue(101L,from,to,BigDecimal.valueOf(65));
		exchangeValue.setPort(
				Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;

		
	}
}


