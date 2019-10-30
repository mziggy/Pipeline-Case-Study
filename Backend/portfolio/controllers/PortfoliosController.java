package com.StockProgram.portfolio.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.StockProgram.portfolio.dao.PortfoliosDao;
import com.StockProgram.portfolio.models.Portfolio;

@RestController
@RequestMapping("/api/v1/portfolios")
public class PortfoliosController {
	
	// API End point which returns a Collection of portfolios
	@Autowired PortfoliosDao dao;
	@GetMapping
	public Collection<Portfolio> getPortfolios(){
		
		// dao.*whatever method you're calling from your dao
		return dao.getPortfolios();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Portfolio portfolio) {
		
	}
	
	
	// API Endpoint that returns a single Portfolio
	@GetMapping("/{stockName}")
	public Portfolio get(@PathVariable("stockName") String stockName) {
		return new Portfolio();
	}
	
	
}
