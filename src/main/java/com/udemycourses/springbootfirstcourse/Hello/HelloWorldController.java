package com.udemycourses.springbootfirstcourse.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloWorldController {

	
	@GetMapping(path = "/helloworld")
	public String helloworld() {
		return "Hello World!!";
	}
	
	@GetMapping(path = "/helloworldBean")
	public UserDetails helloworldBean() {
		return new UserDetails("Sri", "G", "hyd");
	}
}
