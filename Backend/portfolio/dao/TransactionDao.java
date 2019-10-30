package com.StockProgram.portfolio.dao;


import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.StockProgram.portfolio.models.Customer;
import com.StockProgram.portfolio.models.Transaction;


@Component
public class TransactionDao {
	@Autowired private DataSource datasource;
	@Transactional
	public int add(Transaction st) {
		String sql = "INSERT INTO TRANSACTION (BROKERID, CUSTOMERID, PRICE, SECURITYTYPE, TYPE, STATUS) VALUES (?,??,?,?)";
		return new JdbcTemplate(datasource).update(sql, new Object[] {st.getBrokerId(), st.getCustomerId(), st.getPrice(), st.getSecurityType(), st.getType()});
	}
	public Collection<Transaction> get(Customer customer) {
		String sql = "SELECT TRANID, TBROKERID, CUSTOMERID, PRICE, SECURITYTYPE, TYPE, STATUS FROM TRANSACTION WHERE TRANID = ?";
		return new JdbcTemplate(datasource).query(sql, new Object[] {customer.getCustomerId()}, new BeanPropertyRowMapper<Transaction>());
	}
	@Transactional
	public int update(Transaction st) {
		String sql = "UPDATE TRANSACTION SET STATUS = ? WHERE  TRANID = ?";
		return new JdbcTemplate(datasource).update(sql, new Object[] {st.getTranId(), st.getStatus()});
	}
	public Transaction get(int id) {
		String sql = "SELECT TRANID, BROKERID, CUSTOMERID, PRICE, SECURITYTYPE, TYPE, STATUS WHERE  TRANID = ?";
		return new JdbcTemplate(datasource).queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Transaction>());
	}

}

