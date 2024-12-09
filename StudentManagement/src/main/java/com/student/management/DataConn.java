package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConn {
	private static final String URL = "jdbc:postgresql://localhost:5432/user";

	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "root";

	static {
		try {
			// Loading the driver software into the memory
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		// Establish and return a database connection
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	// Close the connection
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
