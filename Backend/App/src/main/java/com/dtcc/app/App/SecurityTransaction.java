package com.dtcc.app.App;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class SecurityTransaction {
	private String transactionId;
	private String securityId;
	private String customerId;
	private String brokerId;
	private String transType; //buy sell
	private Timestamp timedate;
	private int amount;
	private boolean status; //status 1= pending, 2=complete
	private double purchasePrice;
	private double totalPrice;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String tranId) {
		this.transactionId = tranId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public Timestamp getTimedate() {
		return timedate;
	}
	public void setTimedate(Timestamp timestamp) {
		this.timedate = timestamp;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
