package com.StockProgram.portfolio.models;

import java.math.BigDecimal;

// Model Class for Portfolio
public class Portfolio {
	
	private String stockName;
	private int quantity;
	private BigDecimal valueOfStockOwned;
	private BigDecimal currentPrice;
	
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getValueOfStockOwned() {
		return valueOfStockOwned;
	}
	public void setValueOfStockOwned(BigDecimal valueOfStockOwned) {
		this.valueOfStockOwned = valueOfStockOwned;
	}
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	} 

}
