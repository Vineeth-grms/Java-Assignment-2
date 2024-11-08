package com.example.caseStudy1;

import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {

		Bank bank = new Bank();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("\nWelcome to the Bank App");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit Funds");
			System.out.println("3. Withdraw Funds");
			System.out.println("4. Check Balance");
			System.out.println("5. View Transaction History");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");

			int choice = scan.nextInt();
			switch (choice) {

			case 1:
				// Create Account
				System.out.print("Enter user ID: ");
				int userId = scan.nextInt();
				scan.nextLine(); // Consume newline
				System.out.print("Enter user name: ");
				String name = scan.nextLine();
				System.out.print("Enter contact information: ");
				String contactInfo = scan.nextLine();

				User user = new User(userId, name, contactInfo);
				Account account = bank.createAccount(user);
				System.out.println("Account created successfully! Account number: " + account.getAccountNumber());
				break;

			case 2:
				System.out.print("Enter account number: ");
				int depositAccountNumber = scan.nextInt();
				System.out.print("Enter amount to deposit: ");
				double depositAmount = scan.nextDouble();

				bank.deposit(depositAccountNumber, depositAmount);
				break;

			case 3:
				// Withdraw Funds
				System.out.print("Enter account number: ");
				int withdrawAccountNumber = scan.nextInt();
				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = scan.nextDouble();

				bank.withdraw(withdrawAccountNumber, withdrawAmount);
				break;
			case 4:
				// Check Balance
				System.out.print("Enter account number: ");
				int balanceAccountNumber = scan.nextInt();

				bank.checkBalance(balanceAccountNumber);
				break;

			case 5:
				System.out.print("Enter account number: ");
				int historyAccountNumber = scan.nextInt();

				Account historyAccount = bank.findAcount(historyAccountNumber);
				if (historyAccount != null) {
					System.out.println("Transaction History for account #" + historyAccountNumber + ":");
					for (Transaction t : historyAccount.getTransactionsHistory()) {
						System.out.println(t);
					}
				} else {
					System.out.println("Account not found.");
				}

				break;

			case 6:
				// Exit
				System.out.println("Exiting the application. Thank you!");
				scan.close();
				return;

			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}
}
