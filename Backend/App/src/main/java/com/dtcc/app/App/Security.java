package com.dtcc.app.App;

public class Security {
	private String id;
	private String symbol;
	private String name;
	private String type;
	private double price;
	private boolean dividend;
	private double rating;
	private double high;
	private double low;
	
	
	public String getId() {
		return id;
	}
	public void setId(String security_id) {
		this.id = security_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
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
	
}
