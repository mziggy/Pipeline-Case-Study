package com.app.dao;

import java.sql.DriverManager;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dtcc.app.App.Security;
import com.dtcc.app.App.SecurityTransaction;

@Component
public class BuyDAO {
	@Autowired 
	private DataSource datasource;
	
	@Transactional
	public Collection<Security> doTransactions(SecurityTransaction st) {
		String sId = st.getSecurityId();
		String cId = st.getCustomerId();
		String bId = st.getBrokerId();
		String type = "buy";
		int amount = st.getAmount();
		boolean status = st.isStatus();
		double purchase = st.getPurchasePrice();
		double total = st.getPurchasePrice() * st.getAmount();
		
		
		try {
			System.out.println("Connecting.....");
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/StockDB", "guest", "password");
			System.out.println("Connection successful! :)");
			stmt = conn.createStatement();
		}
		
		String sql = "INSERT INTO TRANSACTIONS (SECURITY_ID, CUSTOMER_ID, BROKER_ID, "
				+ "TRANS_TYPE, TIMEDATE, AMOUNT, PASS_FAIL, PURCHASE_PRICE, TOTAL_PRICE) "
				+ "VALUES (?,?,?,BUY,?,?,?,?,?,?)";
		return new JdbcTemplate(datasource).update(sql, new Object[] {st.getSecurityId(), st.getCustomerId(), st.getBrokerId(), st.getTimedate(), st.getAmount(), st.isStatus(), st.getPurchasePrice(), st.getTotalPrice()});
	}

}
