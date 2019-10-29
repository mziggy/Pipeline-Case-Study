package com.app.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.SecurityDAO;
import com.dtcc.app.App.Security;

@RestController
@CrossOrigin
@RequestMapping("/security-details")
public class SecurityController {

	@Autowired
	private SecurityDAO security;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Security> getSecurities() {
		return security.getSecurities();
	}

	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Security getSecurity(@PathVariable("id") int id) {
		return security.getSecurity(id);
	}
	

}