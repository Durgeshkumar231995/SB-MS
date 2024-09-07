package com.trans.spring.aoc.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trans.spring.aoc.data.DAO1;

@Service
public class Business1 {
	@Autowired
	private DAO1 dao1;
	
	public String calculateSomething(){
		//Business Logic
		return dao1.retrieveSomething();
	}
}