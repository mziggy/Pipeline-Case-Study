package com.StockProgram.portfolio.models;


import java.util.Collection;

public class Customer {
	
	private String customerId;
	private String customer_name;
	private String broker_id;
	
	//private Collection<Transaction> transactions;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/*
	public Collection<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}
	*/
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getBroker_id() {
		return broker_id;
	}
	public void setBroker_id(String broker_id) {
		this.broker_id = broker_id;
	}

	

}

