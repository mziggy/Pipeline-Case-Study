package com.dtcc.app.App;

import java.util.Collection;

public class Customer extends User {
	private String customerId;
	private String brokerId;
	private String password;
	private String name;
	private Collection<Security> securities;
	private Collection<SecurityTransaction> transactions;
	

	public Collection<SecurityTransaction> getTransactions() {
		return transactions;
	}
	public Collection<Security> getSecurities() {
		return securities;
	}
	public void setSecurities(Collection<Security> securities) {
		this.securities = securities;
	}
	public void setTransactions(Collection<SecurityTransaction> transactions) {
		this.transactions = transactions;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customer_id) {
		this.customerId = customer_id;
	}
	public String getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(String broker_id) {
		this.brokerId = broker_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}