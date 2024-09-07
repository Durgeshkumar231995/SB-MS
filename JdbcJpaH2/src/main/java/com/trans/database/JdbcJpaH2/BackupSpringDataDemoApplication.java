package com.trans.database.JdbcJpaH2;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trans.database.JdbcJpaH2.entity.Person;
import com.trans.database.JdbcJpaH2.springdata.PersonSpringDataJpa;

//@SpringBootApplication
public class BackupSpringDataDemoApplication implements CommandLineRunner{
 @Autowired
 PersonSpringDataJpa repository;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(BackupSpringDataDemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("User id 10001 -> {}", repository.findById(10001));
		logger.info("Inserting 10004 -> {}", 
				repository.save(new Person("Sabnam", "Mumbai", new Date())));
		
		logger.info("Inserting 10004 -> {}", 
				repository.save(new Person("Sabnam", "Mumbai", new Date())));
		
		logger.info("Update 10003 -> {}", 
				repository.save(new Person(10003, "Durgesh Gupta", "Pune", new Date())));
		
		repository.deleteById(10002);
		
		logger.info("value are -> {} ",repository.findAll());
		/*

		logger.info("Deleting 10002 -> No of Rows Deleted - {}",repository.deleteById(10002)); 
	
	*/
	}

}
