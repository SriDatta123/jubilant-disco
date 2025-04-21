/**
 * 
 */
package com.udemycourses.springbootfirstcourse.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * 
 */
@Entity
@Table(name = "userdetails")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "USER_NAME", length = 50, nullable = false,unique = true)
	private String username;
	
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firstname;
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastname;
	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;
	@Column(name = "ROLE", length = 50, nullable = false)
	private String role;
	
	@Column(name = "SSN", length = 50, nullable = false,unique = true)
	private String ssn;

	/**
	 * NO Argument Constructor
	 */
	public User() {

	}

	/**
	 * 	Fields Constructor
	 * 
	 * @param id
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param role
	 * @param ssn
	 */
	public User(Long id, String username, String firstname, String lastname, String email, String role, String ssn) {
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	//Getters and setter
	
	/**
	 * @return the id
	 */
	public synchronized Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public synchronized void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public synchronized String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public synchronized void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstname
	 */
	public synchronized String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public synchronized void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public synchronized String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public synchronized void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public synchronized String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public synchronized void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public synchronized String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public synchronized void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the ssn
	 */
	public synchronized String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public synchronized void setSsn(String ssn) {
		this.ssn = ssn;
	}

	
	
	//To String
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}


	

	



}
