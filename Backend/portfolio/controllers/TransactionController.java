package com.StockProgram.portfolio.controllers;


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

import com.StockProgram.portfolio.dao.TransactionDao;
import com.StockProgram.portfolio.models.Transaction;


@RestController
@RequestMapping("/transaction")
@CrossOrigin 
public class TransactionController {
	@Autowired private TransactionDao dao;
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> buyTransaction(@RequestBody Transaction transaction) {
		int rows = dao.add(transaction);
		return ResponseEntity.accepted().body("Rows Added " + rows);
	}
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateTransaction(@RequestBody Transaction transaction) {
		int rows = dao.update(transaction);
		return ResponseEntity.accepted().body("Rows Updated " + rows);
	}
	@GetMapping(value="/[id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Transaction getTransaction(@PathVariable("id") int id) {
		return dao.get(id);
	}
	
	 
}

