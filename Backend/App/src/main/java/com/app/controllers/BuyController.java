package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BuyDAO;
import com.dtcc.app.App.SecurityTransaction;

@RestController
@RequestMapping("/transaction/buy")
@CrossOrigin 
public class BuyController {
	@Autowired 
	private BuyDAO dao;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> buyTransaction(@RequestBody SecurityTransaction transaction) {
		int rows = dao.add(transaction);
		return ResponseEntity.accepted().body("Rows Added " + rows);
	}

}
