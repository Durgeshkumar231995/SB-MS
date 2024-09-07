package com.security.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		
		return "spring security";
	}
	
	@GetMapping("/login")
	public String Login() {
		
		return "Login security";
	}

}
