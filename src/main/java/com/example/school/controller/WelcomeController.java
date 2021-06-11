package com.example.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.model.Welcome;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String welcome() {
		System.out.println("welcome method");
		return new String("Welcome");
	}
	
	@GetMapping("/welcome-bean")
	public Welcome welcomeBean() {
		Welcome welcome = new Welcome("Welcome bean");
		System.out.println(welcome);
		return welcome;
	}
	
	@GetMapping("/error")
	public String error() {
		System.out.println("error method");
		return "Error occurred please contact Chandraveer";
	}
}
