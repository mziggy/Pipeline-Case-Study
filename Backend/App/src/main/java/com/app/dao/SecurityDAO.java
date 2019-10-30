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
	
	@Autowired 
	private DataSource datasource;
	
	@Autowired
	private PropertiesDAO propdao;
	
	private final String sql = "SELECT * FROM SECURITIES";
	
	public Collection<Security> getSecurities() {
		return new JdbcTemplate(datasource).query(sql, new BeanPropertyRowMapper<>(Security.class));
	}
	
	public Security getSecurity(String id) {
		System.out.println("in DAO: the id is " + id);
		String sQuery = sql + " WHERE SECURITY_ID = ?";
		return new JdbcTemplate(datasource).queryForObject(sQuery, new Object[] {id}, new BeanPropertyRowMapper<>(Security.class));
	}

	public Collection<Security> getSecurityByCustId(String id) {
		String sqlProp = "SELECT * FROM SECURITIES S JOIN PROPERTIES P "
				+ "ON S.SECURITY_ID = P.SECURITY_ID "
				+ "WHERE CUSTOMER_ID = ?";
		System.out.println("in DAO: the custid is " + id);
		Collection<Security> ct = new JdbcTemplate(datasource).query(sqlProp, new Object[] {id}, new BeanPropertyRowMapper<>(Security.class));
		for (Security security: ct) {
			security.setProperties(propdao.getPropertiesForCustBySecurity(security));
		}
		return ct;
	}
	

}