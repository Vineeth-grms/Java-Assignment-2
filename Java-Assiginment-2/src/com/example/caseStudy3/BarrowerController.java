package com.example.caseStudy3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BarrowerController {

	public void createBarrowerTable() {
		String query = "CREATE TABLE Borrowers ( borrower_id INT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100) )";
		try (Connection connect = DatabaseConnection.geConnection()) {
			Statement stat = connect.createStatement();
			stat.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addBarrower(Barrower barr) {
		String query = "INSERT INTO Borrowers (borrower_id, name, email) VALUES (?, ?, ?)";
		try (Connection con = DatabaseConnection.geConnection()) {
			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, barr.getBorrowerId());
			pre.setString(2, barr.getName());
			pre.setString(3, barr.getEmail());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Barrower> getAllBorrowers() {
		List<Barrower> borrowers = new ArrayList<>();
		String query = "SELECT * FROM Borrowers";
		try (Connection conn = DatabaseConnection.geConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Barrower borrower = new Barrower(rs.getInt("borrower_id"), rs.getString("name"), rs.getString("email"));
				borrowers.add(borrower);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrowers;
	}
}
