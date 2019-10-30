package com.StockProgram.portfolio.models;

import java.util.Collection;

public class Broker {
	private int brokerId;
	private Collection<Customer> customers;
	public int getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(int brokerId) {
		this.brokerId = brokerId;
	}
	public Collection<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}
	 
}
