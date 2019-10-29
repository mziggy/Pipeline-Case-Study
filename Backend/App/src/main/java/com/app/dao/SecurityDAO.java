package com.app.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dtcc.app.App.Security;

@Component
public class SecurityDAO {
	
	@Autowired private DataSource datasource;
	private final String sql = "SELECT * FROM SECURITIES";
	
	public Collection<Security> getSecurities() {
		return new JdbcTemplate(datasource).query(sql, new BeanPropertyRowMapper<>(Security.class));
	}
	
	public Security getSecurity(int id) {
		String sQuery = sql + " WHERE SECURITY_ID = ?";
		return new JdbcTemplate(datasource).queryForObject(sQuery, new Object[] {id}, new BeanPropertyRowMapper<>(Security.class));
	}

}
