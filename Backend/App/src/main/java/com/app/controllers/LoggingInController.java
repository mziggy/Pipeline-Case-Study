package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.LoginService;
import com.dtcc.app.App.User;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/")
public class LoggingInController {
	// @SuppressWarnings("resource")
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestParam("user") String s, @RequestParam("password") String p) {
		User user = new User();
		user.setId(s);
		user.setPassword(p);
		s = loginService.authenticateUser(user);
		System.out.println("In Controller " + user);
		String status = "";
		
		if(s == "SUCCESS") {
			System.out.println("Pass");
		}
		else if(s == "Invalid login credentials") {
			System.out.println("Fail");
			return new User();
		}
		else {
			System.out.println("Error");
		}
		
		return user;
	}
}
