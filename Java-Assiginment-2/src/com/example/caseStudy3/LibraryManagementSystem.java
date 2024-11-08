package com.example.caseStudy3;

import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BookController bookController = new BookController();
		BarrowerController barrowerController = new BarrowerController();
		TransactionController transactionController = new TransactionController();

		while (true) {
			System.out.println("Welcome to Library Management System");
			System.out.println("0. Create All Tables");
			System.out.println("1. Add Book");
			System.out.println("2. List All Books");
			System.out.println("3. Add Borrower");
			System.out.println("4. List All Borrowers");
			System.out.println("5. Issue Book");
			System.out.println("6. Return Book");
			System.out.println("7. Exit");
			System.out.println("Choose an option:");
			int choice = scan.nextInt();
			switch (choice) {
			case 0:
				bookController.createBookTable();
				barrowerController.createBarrowerTable();
				transactionController.createTransactionTable();
				break;
			case 1:
				System.out.print("Enter book ID: ");
				int bookId = scan.nextInt();
				scan.nextLine(); // Consume newline
				System.out.print("Enter book title: ");
				String title = scan.nextLine();
				System.out.print("Enter book author: ");
				String author = scan.nextLine();

				Book book = new Book(bookId, title, author, true);
				bookController.addBook(book);
				break;
			case 2:
				System.out.println("All Books:");
				List<Book> books = bookController.getAllBooks();
				if (books.isEmpty()) {
					System.out.println("No books Available..");
				} else {
					for (Book b : books) {
						System.out.println("Book ID: " + b.getBookId() + " | Title: " + b.getTitle() + " | Author: "
								+ b.getAuthor() + " | Available: " + b.Avalable());
					}
					break;
				}

			case 3:
				System.out.print("Enter borrower ID: ");
				int borrowerId = scan.nextInt();
				scan.nextLine(); // Consume newline
				System.out.print("Enter borrower name: ");
				String name = scan.nextLine();
				System.out.print("Enter borrower email: ");
				String email = scan.nextLine();
				Barrower barrower = new Barrower(borrowerId, name, email);
				barrowerController.addBarrower(barrower);
				System.out.println("Borrower added successfully!");
				break;

			case 4:
				System.out.println("All Borrowers:");
				List<Barrower> borrowers = barrowerController.getAllBorrowers();
				if (borrowers.isEmpty()) {
					System.out.println("No Borrowers Found");
				} else {
					for (Barrower br : borrowers) {
						System.out.println("Borrower ID: " + br.getBorrowerId() + " | Name: " + br.getName()
								+ " | Email: " + br.getEmail());
					}
					break;
				}

			case 5:
				System.out.print("Enter book ID to issue: ");
				int issueBookId = scan.nextInt();
				System.out.print("Enter borrower ID: ");
				int issueBorrowerId = scan.nextInt();

				transactionController.issueBook(issueBookId, issueBorrowerId);
				System.out.println("Book issued successfully!");
				break;
			case 6:
				System.out.println("Active Transactions:");
				List<Transaction> active = transactionController.getActiveTransactions();
				if (active.isEmpty()) {
					System.out.println("No Active Transactions.");
				} else {
					for (Transaction tr : active) {
						System.out.println("Transaction ID: " + tr.getTransactionId() + " | Book ID: " + tr.getBookId()
								+ " | Borrower ID: " + tr.getBorrowerId() + " | Issue Date: " + tr.getIssueDate());
					}

					System.out.print("Enter transaction ID to return book: ");
					int returnTransactionId = scan.nextInt();
					transactionController.returnBook(returnTransactionId);
					System.out.println("Book returned successfully!");
					break;
				}
			case 7:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

}
