package com.trans.database.JdbcJpaH2;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import com.trans.database.JdbcJpaH2.entity.Person;
import com.trans.database.JdbcJpaH2.springdata.PersonSpringDataJpa;

//@SpringBootApplication
public class SpringDataDemoApplication {
 @Autowired
 static PersonSpringDataJpa repository;
	private static Logger logger=LoggerFactory.getLogger(SpringDataDemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
		
		logger.info("Inserting 10004 -> {}", 
				repository.save(new Person("Sabnam", "Mumbai", new Date())));
		logger.info("User id 1 -> {}", repository.findById(10001));
		
		logger.info("Inserting 10004 -> {}", 
				repository.save(new Person("Sabnam", "Mumbai", new Date())));
		
		logger.info("Update 10003 -> {}", 
				repository.save(new Person(10003, "Durgesh Gupta", "Pune", new Date())));
		
		repository.deleteById(10004);
		
		logger.info("value are -> {} ",repository.findAll());

	}
	//@Override
	//public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
			/*

		logger.info("Deleting 10002 -> No of Rows Deleted - {}",repository.deleteById(10002)); 
	
	*/
	//}

}
