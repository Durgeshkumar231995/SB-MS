package com.trans.database.JdbcJpaH2;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trans.database.JdbcJpaH2.entity.Person;
import com.trans.database.JdbcJpaH2.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcJpaH2DemoApplication implements CommandLineRunner{
 @Autowired
	PersonJdbcDao dao;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcJpaH2DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("value are -> {} ",dao.findAll());
		
		logger.info("User id 10001 -> {}", dao.findById(10001));
		
		logger.info("Deleting 10002 -> No of Rows Deleted - {}", 
				dao.deleteById(10002));
		
		logger.info("Inserting 10004 -> {}", 
				dao.insert(new Person(10004, "Sabnam", "Mumbai", new Date())));
		
		logger.info("Update 10003 -> {}", 
				dao.update(new Person(10003, "Durgesh Gupta", "Pune", new Date())));
	}

}
