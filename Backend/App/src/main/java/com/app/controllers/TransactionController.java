package com.app.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.TransactionDAO;
import com.dtcc.app.App.SecurityTransaction;

@RestController
@RequestMapping("/transaction")
@CrossOrigin 
public class TransactionController {
	@Autowired 
	private TransactionDAO dao;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> buyTransaction(@RequestBody SecurityTransaction transaction) {
		int rows = dao.add(transaction);
		return ResponseEntity.accepted().body("Rows Added " + rows);
	}
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateTransaction(@RequestBody SecurityTransaction transaction) {
		int rows = dao.update(transaction);
		return ResponseEntity.accepted().body("Rows Updated " + rows);
	}
	@GetMapping(value="/[id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public SecurityTransaction getTransaction(@PathVariable("id") int id) {
		return dao.get(id);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<SecurityTransaction> getTransactions() {
		return dao.getTransactions();
	}
	
	
	 
}
