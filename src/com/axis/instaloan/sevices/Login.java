package com.axis.instaloan.sevices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.axis.instaloan.db.DBConnection;
import com.axis.instaloan.repo.Repository;

public class Login {
//	DisplayLoanDetails home = new DisplayLoanDetails();
 
	public static boolean CheckLogin(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		String dbPassword = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n");
		displayStyle();
		System.out.println("\n**********************       WELCOME TO INSTA LOAN       **********************");
		displayStyle();
		System.out.println("\n");

		
		dbPassword =  Repository.checkPassword(username);
		
		if (dbPassword != null) {
			if ((password != null || password != " ") && password.equals(dbPassword)) {
				System.out.println("\t\tWelcome " + username + " to the Insta Loan Application");
				
//				int id = rs.getInt("CustomerID");
				
//	            Main.customerId = id;
//	            LoginDetails.getUserLoginDetails(id);
				Repository.setCustomerId(username);	            
				return true;	
			} else {
				System.out.println("--------------------   Invalid Password!!! Please Try Again!!!!   --------------------");
				return false;
			}
		} else {
			System.out.println("--------------------   Invalid Username!!! Please Try Again!!!   --------------------");
			return false;
		}
		
	}
 
	public static void displayStyle() {
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
	}
 
}
 