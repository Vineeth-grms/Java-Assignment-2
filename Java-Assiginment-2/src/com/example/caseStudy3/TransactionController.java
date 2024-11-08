package com.example.caseStudy3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionController {

	private int generateTransactionId() {
		return (int) (new Date().getTime());
	}

	public void createTransactionTable() {
		String query = "CREATE TABLE Transactions ( transaction_id INT PRIMARY KEY, book_id INT, borrower_id INT, issue_date DATE, return_date DATE, FOREIGN KEY (book_id) REFERENCES Books(book_id), FOREIGN KEY (borrower_id) REFERENCES Borrowers(borrower_id) )";
		try (Connection connect = DatabaseConnection.geConnection()) {
			Statement stat = connect.createStatement();
			stat.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void issueBook(int bookId, int borrowerId) {
		String query = "INSERT INTO Transactions (transaction_id, book_id, borrower_id, issue_date, return_date) VALUES (?, ?, ?, ?, ?)";
		String updateBookQuery = "UPDATE Books SET available = ? WHERE book_id = ?";
		try (Connection con = DatabaseConnection.geConnection()) {
			PreparedStatement pre = con.prepareStatement(query);
			PreparedStatement updateBookPre = con.prepareStatement(updateBookQuery);
			int transactionId = generateTransactionId();
			pre.setInt(1, transactionId);
			pre.setInt(2, bookId);
			pre.setInt(3, borrowerId);
			pre.setDate(4, new java.sql.Date(new Date().getTime()));
			pre.setDate(5, null);
			pre.executeUpdate();
			updateBookPre.setBoolean(1, false);
			updateBookPre.setInt(2, bookId);
			updateBookPre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Transaction> getActiveTransactions() {
		List<Transaction> transactions = new ArrayList<>();
		String query = "SELECT * FROM Transactions WHERE return_date IS NULL";
		try (Connection conn = DatabaseConnection.geConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getInt("transaction_id"), rs.getInt("book_id"),
						rs.getInt("borrower_id"), rs.getDate("issue_date"), rs.getDate("return_date"));
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}

	public void returnBook(int transactionId) {
		String query = "UPDATE Transactions SET return_date = ? WHERE transaction_id = ?";
		String updateBookQuery = "UPDATE Books SET available = ? WHERE book_id = (SELECT book_id FROM Transactions WHERE transaction_id = ?)";
		try (Connection conn = DatabaseConnection.geConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				PreparedStatement updateBookPstmt = conn.prepareStatement(updateBookQuery)) {
			pstmt.setDate(1, new java.sql.Date(new Date().getTime()));
			pstmt.setInt(2, transactionId);
			pstmt.executeUpdate();
			updateBookPstmt.setBoolean(1, true);
			updateBookPstmt.setInt(2, transactionId);
			updateBookPstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
