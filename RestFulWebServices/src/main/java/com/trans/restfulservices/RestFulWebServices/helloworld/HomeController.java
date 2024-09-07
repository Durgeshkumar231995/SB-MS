package com.trans.restfulservices.RestFulWebServices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@Autowired
	private MessageSource messageSource; 
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello1")
	@GetMapping(path="/hello")
	public String helloWorld()
	{
		
		return "Hello Durgesh";
	}
	@GetMapping(path="/helloWorldBean")
	public HelloWorldBean helloWorldBean()
	{
		
		return new HelloWorldBean("Welcome to rest api");
	}
	
	//// http://localhost:8080//helloWorld/path-variable/Durgeshkumar
	@GetMapping(path="/helloWorld/path-variable/{name}")
	public HelloWorldBean helloWorldPathVal(@PathVariable String name)
	{
		//constructor we are using here to pass data
		return new HelloWorldBean(String.format("Hello....%s ", name));
	}

	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}
}
