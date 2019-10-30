package com.app.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dtcc.app.App.Customer;
import com.dtcc.app.App.SecurityTransaction;

@Component
public class TransactionDAO {
	@Autowired private DataSource datasource;
	@Transactional
	public int add(SecurityTransaction st) {
		String sql = "INSERT INTO TRANSACTIONS (SECURITY_ID, CUSTOMER_ID, BROKER_ID, TRANS_TYPE, DATE_TIME, AMOUNT, PASS_FAIL, PURCHASE_PRICE, TOTAL_PRICE) VALUES (?,?,?,?,?,?,?,?,?,?)";
		return new JdbcTemplate(datasource).update(sql, new Object[] {st.getSecurityId(), st.getCustomerId(), st.getBrokerId(), st.getTransType(), st.getDate_time(), st.getAmount(), st.isStatus(), st.getPurchasePrice(), st.getTotalPrice()});
	}
	public Collection<SecurityTransaction> get(Customer customer) {
		String sql = "SELECT TRANASCTION_ID, SECURITY_ID, CUSTOMER_ID, BROKER_ID, TRANS_TYPE, TRANS_DATE, TRANS_TIME, AMOUNT, PASS_FAIL, PURCHASE_PRICE, TOTAL_PRICE FROM TRANSACTIONS WHERE TRANSACTION_ID = ?";
		return new JdbcTemplate(datasource).query(sql, new Object[] {customer.getCustomerId()}, new BeanPropertyRowMapper<SecurityTransaction>());
	}
	@Transactional
	public int update(SecurityTransaction st) {
		String sql = "UPDATE TRANSACTIONS SET PASS_FAIL = ? WHERE  TRANASCTION_ID = ?";
		return new JdbcTemplate(datasource).update(sql, new Object[] {st.getTransaction_id(), st.isStatus()});
	}
	public SecurityTransaction get(int id) {
		String sql = "SELECT TRANSACTION_ID, SECURITY_ID, CUSTOMER_ID, BROKER_ID, TRANS_TYPE, DATE_TIME, AMOUNT, PASS_FAIL, PURCHASE_PRICE, TOTAL_PRICE FROM TRANSACTIONS WHERE TRANSACTION_ID = ?";
		return new JdbcTemplate(datasource).queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<SecurityTransaction>(SecurityTransaction.class));
	}
	public Collection<SecurityTransaction> getTransactions() {
		String sql = "SELECT TRANSACTION_ID, SECURITY_ID, CUSTOMER_ID, BROKER_ID, TRANS_TYPE, DATE_TIME, AMOUNT, PASS_FAIL, PURCHASE_PRICE, TOTAL_PRICE FROM TRANSACTIONS";
		return new JdbcTemplate(datasource).query(sql, new BeanPropertyRowMapper<>(SecurityTransaction.class));
	}


}
