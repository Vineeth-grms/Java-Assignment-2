package com.example.caseStudy3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static final String url = "jdbc:mysql://localhost:3306/jdbc";
	public static final String username = "root";
	public static final String password = "@1234";

	public static Connection geConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

}
