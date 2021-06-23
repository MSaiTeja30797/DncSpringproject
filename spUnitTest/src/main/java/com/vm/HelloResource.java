package com.vm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class HelloResource {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello sai";
	}

	@GetMapping(value ="/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudent() {
		return new Student("sai", 22);
	}

}
