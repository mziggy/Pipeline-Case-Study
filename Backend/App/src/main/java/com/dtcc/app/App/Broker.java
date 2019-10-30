package com.dtcc.app.App;

import java.util.Collection;

public class Broker extends User {
	private String brokerId;
	private String password;
	private String first_name;
	private String last_name;
	private Collection<Customer> customers;
	
	public Collection<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
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
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}