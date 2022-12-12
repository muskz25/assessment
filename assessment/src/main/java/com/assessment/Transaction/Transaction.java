package com.assessment.Transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {


	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(long transactionId, Date date, Double transactionAmount, long cardNumber,
			Double cardBalance) {
		super();
		this.transactionId = transactionId;
		this.transactionTimestamp = date;
		this.transactionAmount = transactionAmount;
		this.cardNumber = cardNumber;
		this.cardBalance = cardBalance;
	}
	
	@Id
	private long transactionId;
	private Date transactionTimestamp;
	private Double transactionAmount;
	private long cardNumber;
	private Double cardBalance;
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public Date getTransactionTimestamp() {
		return transactionTimestamp;
	}
	public void setTransactionTimestamp(Date transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Double getCardBalance() {
		return cardBalance;
	}
	public void setCardBalance(Double cardBalance) {
		this.cardBalance = cardBalance;
	}
	
	
}
