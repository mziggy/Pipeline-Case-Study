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
public class BrokerDAO {
	@Autowired private DataSource datasource;
	//@Autowired private BrokerDao dao;
	// Get a broker id and customer id 
	public Broker getBroker(String id) {
		String sql = "SELECT * FROM BROKERS WHERE BROKER_ID = ?";
		return new JdbcTemplate(datasource).queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Broker>(Broker.class));
	}
	
	public Collection<Customer> getCustomersForBroker(String id) {
		String sql = "SELECT * FROM CUSTOMERS C WHERE C.BROKER_ID = ?";
		Collection<Customer> ct = new JdbcTemplate(datasource).query(sql, new Object[] {id },
				new BeanPropertyRowMapper<Customer>(Customer.class));
		return ct;
	}
	 

}