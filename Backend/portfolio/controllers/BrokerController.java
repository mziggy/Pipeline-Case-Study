package com.StockProgram.portfolio.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockProgram.portfolio.dao.BrokerDao;
import com.StockProgram.portfolio.models.Broker;
import com.StockProgram.portfolio.models.Customer;


@RestController
@RequestMapping("/broker")
@CrossOrigin 
public class BrokerController {
	@Autowired private BrokerDao dao; 
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Broker getBroker(@PathVariable("id") int id) {
		return dao.getBroker(id);
 	}
	
	@GetMapping(value="/{id}/customers", produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Customer> get(@PathVariable("id") String id) {
		//gets all transactions for a customer;
		return dao. getCustomersForBroker(id);
 	}
	 
	
	
	 
}
