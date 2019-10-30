package com.app.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dtcc.app.App.Properties;
import com.dtcc.app.App.Security;

@Component
public class PropertiesDAO {
	
	@Autowired
	private DataSource datasource;
	private final String sql = "SELECT PROPERTY_ID, CUSTOMER_ID, SECURITY_ID, SECURITY_NAME, QUANTITY, COST FROM PROPERTIES";
	
	public Collection<Properties> getProperties() {
		return new JdbcTemplate(datasource).query(sql, new BeanPropertyRowMapper<>(Properties.class));
	}
	
	public Properties getProperties(String id) {
		String sQuery = sql + " WHERE PROPERTY_ID = ?";
		return new JdbcTemplate(datasource).queryForObject(sQuery, new Object[] {id}, new BeanPropertyRowMapper<>(Properties.class));
	}
	
	public Collection<Properties> getPropertiesForCustBySecurity(Security security) {
		String query2 = sql + " WHERE CUSTOMER_ID = ?";
		return new JdbcTemplate(datasource).query(query2, new Object[] {security.getSecurity_id()}, new BeanPropertyRowMapper<>(Properties.class));
	}
	
	public Collection<Properties> getPropertiesById(String id) {
		String query2 = sql + " WHERE CUSTOMER_ID = ?";
		System.out.println("in PropDAO: the custid is " + id);
		Collection<Properties> p = new JdbcTemplate(datasource).query(query2, new Object[] {id}, new BeanPropertyRowMapper<>(Properties.class));
		return p;
	}
	

}