package com.udemycourses.springbootfirstcourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemycourses.springbootfirstcourse.Entities.User;
import com.udemycourses.springbootfirstcourse.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Get all users
	 * @return
	 */
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	public User updateUser(User user,long id) {
		user.setId(id);
		
		return userRepository.save(user);
	}
	
	
	public String deleteUser(long id) {

		if(userRepository.findById(id).isPresent()) {
		 userRepository.deleteById(id);
		 return "user deleted";
		}
		else
			return "user does not exist";
	}
	
	public Optional<User> getUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
