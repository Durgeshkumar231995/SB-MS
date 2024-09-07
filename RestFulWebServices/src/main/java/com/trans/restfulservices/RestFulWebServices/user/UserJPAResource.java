package com.trans.restfulservices.RestFulWebServices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {

	@Autowired
	private UserDaoService userDaoService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	// http://localhost:8080/users
	// Select * from user (All Record);
	@GetMapping("/jpa/users")
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	// Select * from user where id=?;
	// Single record
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {

		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);

		EntityModel<User> model = EntityModel.of(user.get());

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
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		// CREATED
		// /user/{id} savedUser.getId()

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	// Delete Record
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		// User user = userRepository.deleteById(id);
		userRepository.deleteById(id);

//		if (user == null)
//			throw new UserNotFoundException("id-" + id);
	}
	
	//http://localhost:8080/jpa/users/10/posts
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return userOptional.get().getPosts();
	}
	
	//http://localhost:8080/jpa/users/101/posts	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		User user = userOptional.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}



}
