package com.trans.mirciservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//in this version issue in pom xml that why eureka not working
// currency exchange service connected to eureka

@EnableFeignClients("com.trans.mirciservices.currencyconversionservice")
@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

}
