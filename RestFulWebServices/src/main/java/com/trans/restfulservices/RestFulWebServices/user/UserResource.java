package com.trans.restfulservices.RestFulWebServices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;

	// http://localhost:8080/users
	// Select * from user (All Record);
	@GetMapping("/users")
	public List<User> getAllUser() {

		return userDaoService.findAll();
	}
	// Select * from user where id=?;
	//Single record
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {

		User user = userDaoService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id :" + id);
		}
		
		EntityModel<User> model=EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUser());

		model.add(linkTo.withRel("all-users"));
		return model;
	}
	/*
	 * @PostMapping("/users") public void createUser(@RequestBody User user) { User
	 * savedUser = userDaoService.save(user);
	 * 
	 * // in this code no response to client at which id record added and below code
	 * again which give response to client in header with url of added record }
	 */
	
	
	
	
	// insert record
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid  @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		// CREATED
		// /user/{id} savedUser.getId()

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	//Delete Record
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteById(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);
	}
}
