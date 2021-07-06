package com.qa.springcars.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Allows for external access to our application via HTTPRequests
public class TestController {
	
	// Allows our program to accept REQUESTS and send RESPONSES!
	
	@GetMapping("/test") // @TypeOfRequest("location")
	public String thisMethod() {
		return "This is a test"; 
	}

}
