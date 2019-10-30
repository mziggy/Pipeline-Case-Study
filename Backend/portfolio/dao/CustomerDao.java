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
public class CustomerDao {
	@Autowired
	private DataSource datasource;
	@Autowired
	private TransactionDao dao;

	// Get a customer name and id based on a customer id
	public Customer getCustomer(String id) {
		String sql = "select * from customers where customer_id = ?";
		Customer ct = new JdbcTemplate(datasource).queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Customer>(Customer.class));
		//ct.setTransactions(dao.get(ct));
		return ct;
	}
	
	// Gets 
	public Collection<Customer> getCustomersForBroker(Broker broker) {
		String sql = "select * from customers where customers.broker_id = ?";
		Collection<Customer> ct = new JdbcTemplate(datasource).query(sql, new Object[] {broker.getBrokerId() },
				new BeanPropertyRowMapper<Customer>(Customer.class));
		
		return ct;
	}
	
	
	

}
