package com.trans.database.JdbcJpaH2;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trans.database.JdbcJpaH2.entity.Person;
import com.trans.database.JdbcJpaH2.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{
 @Autowired
 PersonJpaRepository repository;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("User id 10001 -> {}", repository.findById(10001));
		logger.info("Inserting 10004 -> {}", 
				repository.insert(new Person("Sabnam", "Mumbai", new Date())));
		
		logger.info("Inserting 10004 -> {}", 
				repository.insert(new Person("Sabnam", "Mumbai", new Date())));
		
		logger.info("Update 10003 -> {}", 
				repository.update(new Person(10003, "Durgesh Gupta", "Pune", new Date())));
		
		repository.deleteById(10002);
		
		logger.info("value are -> {} ",repository.findAll());
		/*

		logger.info("Deleting 10002 -> No of Rows Deleted - {}",repository.deleteById(10002)); 
	
	*/
	}

}
