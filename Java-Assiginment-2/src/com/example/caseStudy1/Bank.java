package com.example.caseStudy1;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private List<Account> accounts;

	public Bank() {
		accounts = new ArrayList();
	}

	public Account createAccount(User user) {
		Account account = new Account(user);
		accounts.add(account);
		return account;

	}

	public Account findAcount(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	public void deposit(int accountNumber, double amount) {
		Account account = findAcount(accountNumber);
		if (account != null) {
			account.deposit(amount);
			System.out.println("Deposited " + amount + " into account  " + accountNumber);
		} else {
			System.out.println("Account Not Found..");
		}

	}

	public void withdraw(int accountNumber, double amount) {
		Account account = findAcount(accountNumber);
		if (account != null) {
			account.withdraw(amount);
			System.out.println("WithDrew " + amount + " into account :  " + accountNumber);
		} else {
			System.out.println("Account Not Found..");
		}

	}

	public void checkBalance(int accountNumber) {
		Account account = findAcount(accountNumber);
		if (account != null) {
			System.out.println("Balance for account : " + accountNumber + ": " + account.checkBalance());
		} else {
			System.out.println("Account Not Found..");
		}

	}

}
