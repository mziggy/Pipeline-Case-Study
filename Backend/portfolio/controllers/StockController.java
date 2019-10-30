package com.StockProgram.portfolio.controllers;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StockProgram.portfolio.dao.StockDao;
import com.StockProgram.portfolio.models.Stock;


@RestController
@RequestMapping("/stock")
@CrossOrigin 
public class StockController {
	@Autowired private StockDao dao;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Stock> getStocks(){
		return dao.getStocks();
	}
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Stock getStock(@PathVariable("id") int id){
		return dao.getStock(id);
	}
}
