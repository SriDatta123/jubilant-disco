package com.udemycourses.springbootfirstcourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.udemycourses.springbootfirstcourse.Entities.User;
import com.udemycourses.springbootfirstcourse.exceptions.UserExistsException;
import com.udemycourses.springbootfirstcourse.exceptions.UserNotFoundException;
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
	
	public User createUser(User user) throws UserExistsException {
		
		if(userRepository.existsByUsernameOrSsn(user.getUsername(),user.getSsn()))
			throw new UserExistsException("User with given username exists");
		
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long id) throws UserNotFoundException{
		
		Optional<User>  user = userRepository.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("User not found");
		
		
		return user;
	}
	
	public User updateUser(User user,long id) throws UserNotFoundException {
		
		Optional<User>  user1 = userRepository.findById(id);
		
		if(!user1.isPresent())
			throw new UserNotFoundException("User not found");
		user.setId(id);
		return userRepository.save(user);
	}
	
	
	public String deleteUser(long id) {

		Optional<User>  user1 = userRepository.findById(id);
		
		if(!user1.isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
		
		

		 userRepository.deleteById(id);
		 return "user deleted";

	}
	
	public Optional<User> getUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
