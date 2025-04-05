package com.udemycourses.springbootfirstcourse.Hello;

import java.util.Objects;

public class UserDetails {

	private String FirstName;
	
	private String LastName;

	
	private String City;


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public UserDetails(String firstName, String lastName, String city) {
		super();
		FirstName = firstName;
		LastName = lastName;
		City = city;
	}


	@Override
	public String toString() {
		return "UserDetails [FirstName=" + FirstName + ", LastName=" + LastName + ", City=" + City + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getCity()=" + getCity() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(City, FirstName, LastName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		return Objects.equals(City, other.City) && Objects.equals(FirstName, other.FirstName)
				&& Objects.equals(LastName, other.LastName);
	}


	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
