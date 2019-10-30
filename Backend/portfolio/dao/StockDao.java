package com.StockProgram.portfolio.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.StockProgram.portfolio.models.Stock;


@Component
public class StockDao {
	@Autowired private DataSource datasource;
	private final String sql = "SELECT STOCKID , SYMBOL, DESCRIPTION, PRICE FROM STOCK ";
 
	public Collection<Stock> getStocks() {
		return new JdbcTemplate(datasource).query(sql,new BeanPropertyRowMapper<>(Stock.class));
	}

	public Stock getStock(int id) {
		String sQuery = sql + " WHERE STOCKID = ?";
		return new JdbcTemplate(datasource).queryForObject(sQuery,new Object[] {id},new BeanPropertyRowMapper<>(Stock.class));

	}
	

}
