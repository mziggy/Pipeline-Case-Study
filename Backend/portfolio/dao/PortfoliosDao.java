package com.StockProgram.portfolio.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.StockProgram.portfolio.models.Portfolio;

@Component
public class PortfoliosDao {

	@Autowired DataSource datasource;
	private final String sql = "SELECT STOCKNAME, QUANTITY, VALUEOFSTOCK, CURRENTCOST";
	
	public Collection<Portfolio> getPortfolios() {
		return new JdbcTemplate(datasource).query(sql,new BeanPropertyRowMapper<>(Portfolio.class));
	}

	public Portfolio getPortfolio(String stockName) {
		String sQuery = sql + " WHERE stockName = ?";
		return new JdbcTemplate(datasource).queryForObject(sQuery,new Object[] {stockName},new BeanPropertyRowMapper<>(Portfolio.class));

	}
	
	
	/*private class PortfolioRowMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			
			// row implemented
			int securityid = rs.getInt(1);
			
			// Create security object
			
			
			// create transaction 
			
			
			return null;
		}*/
		
	}

