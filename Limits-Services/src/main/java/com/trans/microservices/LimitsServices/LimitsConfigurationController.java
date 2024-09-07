package com.trans.microservices.LimitsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trans.microservices.LimitsServices.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	@Autowired
	private Configuration configuration;
	
	//http://localhost:8080/limits
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		
		LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMaximum(), 
				configuration.getMinimum());
		return limitConfiguration;
		
		//return new LimitConfiguration(100,200);
	}

}
