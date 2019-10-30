package com.app.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dtcc.app.App.Broker;
import com.dtcc.app.App.Customer;

@Component
public class CustomerDAO {
	@Autowired
	private DataSource datasource;
	@Autowired
	private SecurityDAO securitydao;
	@Autowired
	private TransactionDAO transdao;

	//methods that work with TransactionDAO 
	public Customer getCustomer(String id) {
		String sql = "SELECT CUSTOMER_ID FROM CUSTOMERS WHERE CUSTOMER_ID = ?";
		Customer ct = new JdbcTemplate(datasource).queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Customer>());
		System.out.println("in CustomerDAO: the custid is " + ct.getCustomerId());
		ct.setTransactions(transdao.get(ct));
		return ct;
	}
	
	public Collection<Customer> getCustomersForBroker(Broker broker) {
		String sql = "SELECT CUSTOMER_ID, NAME FROM CUSTOMERS WHERE BROKER_ID = ?";
		Collection<Customer> ct = new JdbcTemplate(datasource).query(sql, new Object[] {broker.getBrokerId() },
				new BeanPropertyRowMapper<Customer>());
		for (Customer customer : ct) {
			customer.setTransactions(transdao.get(customer));
		} 
		return ct;
	}
	
	
	//methods that work with SecurityDAO

}
