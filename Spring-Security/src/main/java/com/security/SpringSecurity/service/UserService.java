package com.security.SpringSecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.SpringSecurity.model.User;

@Service
public class UserService {
	
	List<User> list= new ArrayList<>();

	public UserService() {
		list.add(new User("Durgesh","Durgesh","abc@gmail.com"));
		list.add(new User("SBNM","SBNM","SBNM@gmail.com"));
		list.add(new User("pravin","pravin","pravin@gmail.com"));
	}
	
	//all user
	public List<User> getAllUser(){
		
		return this.list;
	}
	// get single user
public User getUser(String userName){
		
		//return this.list.stream().filter((user)->user.getUserName().equals(userName)).findAny().get();
		
		return this.list.stream().filter((user)->user.getUserName().equals(userName)).findAny().orElse(null);
	}
	
// new user 
	public User addUser(User user) {
		this.list.add(user);
		
		return user;
		
	}
	

}
