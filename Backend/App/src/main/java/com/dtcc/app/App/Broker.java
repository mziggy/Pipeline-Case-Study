package com.dtcc.app.App;

public class Broker extends User {
	private String broker_id;
	private String password;
	private String first_name;
	private String last_name;
	public String getBroker_id() {
		return broker_id;
	}
	public void setBroker_id(String broker_id) {
		this.broker_id = broker_id;
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
