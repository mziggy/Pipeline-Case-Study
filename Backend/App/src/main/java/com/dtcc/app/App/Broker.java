package com.dtcc.app.App;

import java.util.Collection;

public class Broker extends User {
	private String broker_id;
	private String broker_pwd;
	private String broker_fn;
	private String broker_ln;
	private Collection<Customer> customers;
	
	public Collection<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}
	public String getId() {
		return broker_id;
	}
	public void setId(String broker_id) {
		this.broker_id = broker_id;
	}
	public String getPassword() {
		return broker_pwd;
	}
	public void setPassword(String password) {
		this.broker_pwd = password;
	}
	public String getBroker_fn() {
		return broker_fn;
	}
	public void setBroker_fn(String first_name) {
		this.broker_fn = first_name;
	}
	public String getBroker_ln() {
		return broker_ln;
	}
	public void setBroker_ln(String last_name) {
		this.broker_ln = last_name;
	}

}