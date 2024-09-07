package com.trans.spring.aoc.SpringAOP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.trans.spring.aoc.Business.Business1;
import com.trans.spring.aoc.Business.Business2;

//CommandLineRunner invoke run method when we execute file

@SpringBootApplication
@ComponentScan(basePackages={"com.trans.spring.aoc.Business","com.trans.spring.aoc.data","com.trans.spring.aoc.aspect"})
public class SpringAopApplication implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Business1 business1;

	@Autowired
	private Business2 business2;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(business1.calculateSomething());
		logger.info(business2.calculateSomething());
	}
}
