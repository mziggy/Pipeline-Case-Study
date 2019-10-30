package com.StockProgram.portfolio.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockProgram.portfolio.dao.CustomerDao;
import com.StockProgram.portfolio.models.Customer;


@RestController
@RequestMapping("/customer")
@CrossOrigin 
public class CustomerController {
	@Autowired private CustomerDao dao; 
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomer(@PathVariable("id") String id) {
		//gets all transactions for a customer;
		return dao.getCustomer(id);
 	}


	
	
	
	
	 
	
	 
}
