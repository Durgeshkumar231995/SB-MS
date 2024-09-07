package com.trans.database.JdbcJpaH2.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trans.database.JdbcJpaH2.entity.Person;

public interface PersonSpringDataJpa extends JpaRepository<Person,Integer>{
	

}
