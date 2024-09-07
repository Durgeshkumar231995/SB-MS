package com.trans.spring.aoc.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trans.spring.aoc.data.DAO2;

@Service
public class Business2 {

	@Autowired
	private DAO2 dao2;
	
	public String calculateSomething(){
		//Business Logic
		return dao2.retrieveSomething();
	}
}