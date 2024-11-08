package com.example.caseStudy1;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {

	private int transactionId;
	private double amount;
	private String transactionType;
	private LocalDate date;
	private static int COUNT = 200;

	public Transaction(String transactionType, double amount) {
		this.transactionId = COUNT++;
		this.amount = amount;
		this.transactionType = transactionType;
		this.date = LocalDate.now();
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", transactionType="
				+ transactionType + ", date=" + date + "]";
	}

}
