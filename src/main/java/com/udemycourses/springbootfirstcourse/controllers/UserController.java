package com.udemycourses.springbootfirstcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udemycourses.springbootfirstcourse.Entities.User;
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
	public Object addUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping(path = "/users/{id}")
	public Object getAllUsers(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PutMapping(path = "/users/{id}")
	public Object updateUser(@PathVariable Long id , @RequestBody User user) {
		return userService.updateUser(user, id);
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
