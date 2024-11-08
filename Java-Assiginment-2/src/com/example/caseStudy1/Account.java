package com.example.caseStudy1;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int accountNumber;
	private String holderName;
	private double balance;
	private User user;
	private List<Transaction> transactions;

	private static int COUNT = 100;

	public Account(User user) {
		super();
		this.accountNumber = COUNT++;
		this.balance = 0;
		this.user = user;
		this.transactions = new ArrayList<>();
	}

	public double checkBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			transactions.add(new Transaction("Deposit", amount));
		}

	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			transactions.add(new Transaction("Withdraw", amount));
		} else {
			System.out.println("Insuffcient funds");
		}

	}

	public List<Transaction> getTransactionsHistory() {
		return transactions;
	}

}
