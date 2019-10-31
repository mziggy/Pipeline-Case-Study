package com.dtcc.app.App;

import java.util.Collection;

public class Security {
	private String security_id;
	private String symbol;
	private String security_name;
	private String type;
	private double price;
	private boolean dividend;
	private String rating;
	private double high;
	private double low;
	private Collection<Properties> properties;
	
	public String getSecurity_id() {
		return security_id;
	}
	public void setSecurity_id(String security_id) {
		this.security_id = security_id;
	}
	public String getSecurity_name() {
		return security_name;
	}
	public void setSecurity_name(String name) {
		this.security_name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean getDividend() {
		return dividend;
	}
	public void setDividend(boolean dividend) {
		this.dividend = dividend;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Collection<Properties> getProperties() {
		return properties;
	}
	public void setProperties(Collection<Properties> properties) {
		this.properties = properties;
	}
	
}