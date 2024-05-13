package com.musicalapp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction")
public class TransactionDetails {
   
	@Id
	 @Column(name="orderId")
	private String orderId;

	 @Column(name="currency")
	private String currency;
	 

	 @Column(name="amount")
	private Integer amount;
	
	public TransactionDetails(String orderId, String currency, Integer amount) {
		super();
		this.orderId = orderId;
		this.currency = currency;
		this.amount = amount;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "TransactionDetails [orderId=" + orderId + ", currency=" + currency + ", amount=" + amount + "]";
	}
}