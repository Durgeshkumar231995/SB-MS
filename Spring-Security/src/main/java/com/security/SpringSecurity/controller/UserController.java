package com.security.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.SpringSecurity.model.User;
import com.security.SpringSecurity.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//all user
	@GetMapping("/")
	
	public List<User> getAllUsers()
	
	{
		
		return this.userService.getAllUser();
	}
	
	//single user
	//@PreAuthorize("hasRole('ADMIN')")	
	@GetMapping("/{username}")
		
		public User getUser(@PathVariable("username") String userName)
		
		{
			
			return this.userService.getUser(userName);
		}
		
		@PostMapping("/")
		public User add(@RequestBody User user) {
			return this.userService.addUser(user);
			
		}
		

}
