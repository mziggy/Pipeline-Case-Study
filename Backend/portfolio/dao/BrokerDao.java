package com.StockProgram.portfolio.dao;

import java.util.Collection;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.StockProgram.portfolio.models.Broker;
import com.StockProgram.portfolio.models.Customer;


@Component
public class BrokerDao {
	@Autowired private DataSource datasource;
	@Autowired private BrokerDao dao;
	// Get a broker id and customer id 
	public Broker getBroker(int id) {
		String sql = "SELECT BROKER_ID, CUSTOMER_ID FROM BROKER WHERE BROKERID = ?";
		Broker br = new JdbcTemplate(datasource).queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Broker>());
		return br;
	}

	public Collection<Customer> getCustomersForBroker(String id) {
		String sql = "select * from customers where customers.broker_id = ?";
		Collection<Customer> ct = new JdbcTemplate(datasource).query(sql, new Object[] {id },
				new BeanPropertyRowMapper<Customer>(Customer.class));
		
		return ct;
	}
	 

}
