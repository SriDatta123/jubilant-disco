package com.udemycourses.springbootfirstcourse.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.udemycourses.springbootfirstcourse.Entities.User;
import com.udemycourses.springbootfirstcourse.exceptions.UserExistsException;
import com.udemycourses.springbootfirstcourse.exceptions.UserNotFoundException;
import com.udemycourses.springbootfirstcourse.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/users")
	public Object getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder) {
		try {
			userService.createUser(user);
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
			
			return new ResponseEntity<Void>( headers, HttpStatus.CREATED);
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@GetMapping(path = "/users/{id}")
	public Object getAllUsers(@PathVariable Long id) {
		try {
			return userService.getUserById(id);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@PutMapping(path = "/users/{id}")
	public Object updateUser(@PathVariable Long id , @RequestBody User user) {
		try {
			return userService.updateUser(user, id);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@DeleteMapping(path = "/users/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser( id);
	}
	
	@GetMapping(path = "/users/byusername/{username}")
	public Object getUserByUsername(@PathVariable String username) {
		return userService.getUserByUserName(username);
	}
	
	

}
