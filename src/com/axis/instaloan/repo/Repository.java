package com.axis.instaloan.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.axis.instaloan.db.DBConnection;
import com.axis.instaloan.entity.Account;
import com.axis.instaloan.entity.Customer;
import com.axis.instaloan.entity.EmiPayment;
import com.axis.instaloan.entity.Loan;

public class Repository {

	public static int customerId;

	public static void setCustomerId(String username) throws SQLException {
		String selectCustomerId = "select CustomerID from account where Username=?";
		int customerId = 0;
		PreparedStatement pstmt = DBConnection.getData(selectCustomerId);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			customerId = rs.getInt("CustomerID");
		}
		Repository.customerId = customerId;
	}

	public static void createCustomerTable() {
		String createCustomer = "CREATE TABLE IF NOT EXISTS customers (" + "CustomerID INT AUTO_INCREMENT PRIMARY KEY, "
				+ "FullName VARCHAR(255), " + "DateOfBirth VARCHAR(255), " + "Gender VARCHAR(255), "
				+ "MobileNumber BIGINT UNIQUE, " + "Email VARCHAR(255) UNIQUE, " + "PanNumber VARCHAR(255) UNIQUE, "
				+ "AadharNumber BIGINT UNIQUE, " + "AccountNumber BIGINT UNIQUE, " + "CibilScore INT" + ")";
		PreparedStatement pstmt = DBConnection.getData(createCustomer);

		try {
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getCustomerIdbyEmail(String email) throws SQLException {
		String selectCustomerId = "select CustomerID from customers where Email=?";
		int customerId = 0;
		PreparedStatement pstmt = DBConnection.getData(selectCustomerId);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			customerId = rs.getInt("CustomerID");
		}
		return customerId;
	}

	public static void insertCustomerDetails(Customer customer) throws SQLException {
		String insertAccountQuery = "INSERT INTO customers (FullName, DateOfBirth, Gender, MobileNumber, Email, PanNumber, AadharNumber, AccountNumber, CibilScore) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

		PreparedStatement pstmt = DBConnection.getData(insertAccountQuery);

		pstmt.setString(1, customer.getFullName());
		pstmt.setString(2, customer.getDob());
		pstmt.setString(3, customer.getGender());
		pstmt.setLong(4, customer.getMobileNumber());
		pstmt.setString(5, customer.getEmail());
		pstmt.setString(6, customer.getPanNumber());
		pstmt.setLong(7, customer.getAadharNumber());
		pstmt.setLong(8, customer.getAccountNumber());
		pstmt.setLong(9, customer.getCibilScore());

		pstmt.executeUpdate();

	}

	public static void createAccountsTable() {

		String createTableSQL2 = "CREATE TABLE IF NOT EXISTS account (" + "AccountId INT AUTO_INCREMENT PRIMARY KEY, "
				+ "CustomerID INT, " + "Username VARCHAR(50) UNIQUE, " + "Password VARCHAR(255), "
				+ "FOREIGN KEY (CustomerID) REFERENCES customers(CustomerID)" + ")";
		PreparedStatement pstmt = DBConnection.getData(createTableSQL2);
		try {
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean hasUserNameExist(String username) throws SQLException {

		String checkUsernameExistQuery = "select * from account where Username=?";
		PreparedStatement pst = DBConnection.getData(checkUsernameExistQuery);

		pst.setString(1, username);
		ResultSet r = null;
		r = pst.executeQuery();

		if (r.next()) {
			return true;
		} else {
			return false;
		}
	}

	public static void insertAccountsData(Account account, Customer customer) throws SQLException {

		String email = customer.getEmail();

		int customerId = getCustomerIdbyEmail(email);

		String insertAccountQuery = "INSERT INTO account (CustomerID, Username, Password) VALUES (?, ?, ?);";

		PreparedStatement pstmt = DBConnection.getData(insertAccountQuery);

		pstmt.setInt(1, customerId);
		pstmt.setString(2, account.getUsername());
		pstmt.setString(3, account.getPassword());

		pstmt.executeUpdate();
	}

	public static String checkPassword(String username) throws SQLException {

		String selectQuery = "select * from account where Username=?";
		PreparedStatement pstmt = DBConnection.getData(selectQuery);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			String dbPassword = rs.getString("Password");
			return dbPassword;
		}
		return null;
	}

	public static void createLoansTable() throws SQLException {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS loans (" + "LoanID INT AUTO_INCREMENT PRIMARY KEY, "
				+ "CustomerID INT, " + "LoanAmount DOUBLE, " + "InterestRate FLOAT, " + "StartDate DATE, "
				+ "EndDate DATE, " + "MonthlyPayment DOUBLE, " + "LoanTypeName VARCHAR(255), "
				+ "BalancePayment DOUBLE, " + "TotalPayment DOUBLE, "
				+ "FOREIGN KEY (CustomerID) REFERENCES customers(CustomerID)" + ")";
		PreparedStatement pstTable = DBConnection.getData(createTableSQL);
		pstTable.execute();

	}

	public static boolean hasExistingLoan() throws SQLException {
		String query = "SELECT * FROM loans WHERE CustomerID = ?";

		PreparedStatement statement = DBConnection.getData(query);

		statement.setInt(1, customerId);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	public static void createEmiPaymentTable() throws SQLException {

		String createTableSQL = "CREATE TABLE IF NOT EXISTS emi_payment (" + "CustomerID INT,"
				+ "Payment_id INT AUTO_INCREMENT PRIMARY KEY," + "Amount DECIMAL(10, 2)," + "Status VARCHAR(50),"
				+ "Payment_Datetime DATETIME, " + "FOREIGN KEY (CustomerID) REFERENCES customers(CustomerID)" + ")";

		PreparedStatement pstmt = DBConnection.getData(createTableSQL);
		pstmt.execute();

	}

	public static void insertLoanData(Loan loan) throws SQLException {
		String query = "INSERT INTO loans (CustomerID, LoanAmount, InterestRate, StartDate, EndDate, "
				+ "MonthlyPayment, LoanTypeName,BalancePayment, TotalPayment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pst = DBConnection.getData(query);

		pst.setInt(1, customerId);
		pst.setDouble(2, loan.getLoanAmount());
		pst.setFloat(3, loan.getInterestRate());
		pst.setString(4, loan.getStartDate());
		pst.setString(5, loan.getEndDate());
		pst.setDouble(6, loan.getEmi());
		pst.setString(7, loan.getLoanType());
		pst.setDouble(8, loan.getBalanceAmount());
		pst.setDouble(9, loan.getTotalLoanAmount());

		pst.executeUpdate();
	}

	public static ResultSet displayloanData() throws SQLException {

		String selectQuery = "select * from loans where CustomerID=?";
		PreparedStatement pstmt = DBConnection.getData(selectQuery);
		pstmt.setInt(1, customerId);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			return rs;
		} else {
			return null;
		}
	}

	public static Loan loanObjData() throws SQLException {
		ResultSet rs = displayloanData();

		Loan loan = new Loan(rs.getInt("CustomerID"), rs.getString("LoanTypeName"), rs.getDouble("LoanAmount"),
				rs.getFloat("InterestRate"), rs.getString("StartDate"), rs.getString("EndDate"), 10,
				rs.getDouble("MonthlyPayment"), rs.getDouble("BalancePayment"), rs.getDouble("TotalPayment"));

		return loan;
	}

	public static ResultSet displayCustomersAllData() throws SQLException {

		String selectQuery = "select * from customers where CustomerID=?";
		PreparedStatement pstmt = DBConnection.getData(selectQuery);
		pstmt.setInt(1, customerId);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			return rs;
		} else {
			return null;
		}
	}

	public static Customer customerOjbData() throws SQLException {
		ResultSet rs = displayCustomersAllData();

		Customer customer = new Customer(rs.getInt("CustomerID"), rs.getString("FullName"), rs.getString("DateOfBirth"),
				rs.getString("Email"), rs.getString("PanNumber"), rs.getLong("AadharNumber"),
				rs.getLong("AccountNumber"), rs.getString("Gender"), rs.getLong("MobileNumber"),
				rs.getInt("CibilScore"));

		return customer;
	}

	public static void insertEmiPaymentData(EmiPayment emiPay) throws SQLException {
		// Insert data
		String insertData = "INSERT INTO emi_payment (CustomerID, Amount, Status, Payment_Datetime) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = DBConnection.getData(insertData);
		pstmt.setInt(1, customerId);
		pstmt.setDouble(2, emiPay.getPaymentAmount());
		pstmt.setString(3, emiPay.getStatus());
		pstmt.setString(4, emiPay.getPaymentDateTime());

		pstmt.executeUpdate();
	}

	public static void updateBalanceAmount(double balance) throws SQLException {
		String query = "UPDATE loans " + "SET BalancePayment = " + balance + " WHERE CustomerID = " + customerId + ";";

		PreparedStatement pst = DBConnection.getData(query);

		pst.executeUpdate();

	}

	public static int userUpdate(int choice) throws SQLException {
		Scanner sc = new Scanner(System.in);
		PreparedStatement pstmt = null;
		switch (choice) {
		case 1:
			System.out.print("\nEnter Updated Full Name --> ");
			String newFullName = sc.nextLine();
			String updateQuery = "UPDATE Customers SET FullName=? WHERE CustomerID=?";
			pstmt = DBConnection.getData(updateQuery);
			pstmt.setString(1, newFullName);
			pstmt.setInt(2, customerId);
			break;
		case 2:
			System.out.print("\nEnter Updated Email -->");
			String newEmail = sc.nextLine();
			// Consume newline character
			String updateQueryEmail = "UPDATE Customers SET Email=? WHERE CustomerID=?";
			pstmt = DBConnection.getData(updateQueryEmail);
			pstmt.setString(1, newEmail);
			pstmt.setInt(2, customerId);
			break;

		case 3:
			System.out.print("\nEnter Updated mobile Number -->");
			String newPhone = sc.nextLine();
			// Consume newline character
			String updateQueryMobile = "UPDATE Customers SET Phone=? WHERE CustomerID=?";
			pstmt = DBConnection.getData(updateQueryMobile);
			pstmt.setString(1, newPhone);
			pstmt.setInt(2, customerId);
			break;

		case 4:
			System.out.print("\nEnter Updated CibilScore --> ");
			String newCibilScore = sc.nextLine();
			// Consume newline character
			String updateQueryAddress = "UPDATE Customers SET CibilScore=? WHERE CustomerID=?";
			pstmt = DBConnection.getData(updateQueryAddress);
			pstmt.setString(1, newCibilScore);
			pstmt.setInt(2, customerId);
			break;
		}

		int updateStatus = pstmt.executeUpdate();

		return updateStatus;

	}
}
