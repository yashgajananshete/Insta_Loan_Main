package com.axis.instaloan.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static Connection connection;
	private Statement statement;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	
	public static Connection connectDB(){
		String url = "jdbc:mysql://localhost:3306/InstaLoan";
		try {
			connection = DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	public void closeResouces() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
	
	public static PreparedStatement getData(String query) {
		DBConnection.connectDB();		
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			return pstmt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}