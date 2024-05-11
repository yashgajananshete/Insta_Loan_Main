package com.axis.instaloan.sevices;

import java.sql.SQLException;

import com.axis.instaloan.repo.Repository;

import java.sql.ResultSet;



public class DisplayLoanDetails {

	public static void Display() throws SQLException {

		ResultSet rs = Repository.displayloanData();

		if (rs != null) {
				System.out.println("\nLoan Details-->");
				displayStyle();
				System.out.printf("\n\n\t%-10s %-15s %-15s %-15s %-15s %-15s %-20s %n", "Loan Id", "Loan Type",
						"Loan Amount", "Interest Rate", "Start Date", "End Date", "Monthly Payment");
				System.out.printf("\n\t%-10d %-15s %-15d %-15.2f %-15tD %-15tD %-20.2f %n", rs.getInt(1),
						rs.getString(8), rs.getLong(3), rs.getDouble(4), rs.getDate(5), rs.getDate(6), rs.getDouble(7));
				System.out.println();
				displayStyle();
				System.out.println();
		} else {
			System.out.println("----------------------  You have not applied for any loan  ----------------------");
		}

	}

	public static void displayStyle() {
		for (int i = 0; i < 120; i++) {
			System.out.print("*");
		}
	}
}
