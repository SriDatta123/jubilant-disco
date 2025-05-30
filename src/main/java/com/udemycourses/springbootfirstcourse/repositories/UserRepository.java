package com.udemycourses.springbootfirstcourse.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemycourses.springbootfirstcourse.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public Optional<User> findByUsername(String username);
	
	
	public boolean existsByUsernameOrSsn(String username, String ssn);

}
