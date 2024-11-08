package com.example.caseStudy3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookController {

	public void createBookTable() {
		String query = "CREATE TABLE Books ( book_id INT PRIMARY KEY, title VARCHAR(100), author VARCHAR(100), available BOOLEAN) ";
		try (Connection connect = DatabaseConnection.geConnection()) {
			Statement stat = connect.createStatement();
			stat.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addBook(Book book) {
		String query = "INSERT INTO Books (book_id, title, author, available) VALUES (?, ?, ?, ?)";
		try (Connection con = DatabaseConnection.geConnection()) {
			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, book.getBookId());
			pre.setString(2, book.getTitle());
			pre.setString(3, book.getAuthor());
			pre.setBoolean(4, book.Avalable());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<Book>();
		String query = "SELECT * FROM Books";
		try (Connection con = DatabaseConnection.geConnection()) {
			Statement stat = con.createStatement();
			ResultSet res = stat.executeQuery(query);

			while (res.next()) {
				Book book = new Book(res.getInt("book_id"), res.getString("title"), res.getString("author"),
						res.getBoolean("available"));

				list.add(book);
			}
		} catch (SQLException e) {

		}
		return list;
	}

	public int updateBook(Book book) {
		String query = "Update Books set title = ?,author = ? Where bookId = ?";

		try (Connection con = DatabaseConnection.geConnection()) {
			PreparedStatement pre = con.prepareStatement(query);
			pre.setString(1, book.getTitle());
			pre.setString(2, book.getAuthor());
			pre.setInt(3, book.getBookId());
			int result = pre.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return 0;

	}

	public int deleteBook(Book book) {
		String query = "Delete from Books where bookId = ?";
		try (Connection con = DatabaseConnection.geConnection()) {
			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, book.getBookId());
			int result = pre.executeUpdate();
			return result;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}
}
