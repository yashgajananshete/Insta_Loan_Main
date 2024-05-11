package com.axis.instaloan.sevices;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.axis.instaloan.db.DBConnection;
import com.axis.instaloan.entity.Account;
import com.axis.instaloan.entity.Customer;
import com.axis.instaloan.repo.Repository;

public class Register {

	public void CustomerDetails() throws SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Username: ");
		String CusUsername = sc.next();
		System.out.print("Enter Password: ");
		String CusPassword = sc.next();

		boolean checkUsernameExist = Repository.hasUserNameExist(CusUsername);
		
		if (checkUsernameExist) {
			System.out.println("\n-------------------------   UserName Already Exist   -------------------------");
		} else {

			System.out.print("Enter Your Name : ");
			String name = sc.next();

			System.out.println("Gender : ");
			String gender = sc.next();

			System.out.print("Enter DOB (yyyy-mm-dd): ");
			String dob = sc.next();

			System.out.print("Enter Email : ");
			String email = sc.next();

			System.out.print("Enter Mobile Number: ");
			long mobileNumber = sc.nextLong();

			System.out.print("Enter Pan Number : ");
			String pan = sc.next();

			System.out.println("Enter Aadhar Number :");
			long aadhar = sc.nextLong();

			System.out.println("Enter Account Number :");
			long accountNumber = sc.nextLong();

			System.out.println("Enter Cibil Score :");
			int cibilScore = sc.nextInt();

			Customer customer = new Customer(name, dob, email, pan, aadhar, accountNumber, gender, mobileNumber,
					cibilScore);

			Repository.insertCustomerDetails(customer);

			Account account = new Account(CusUsername, CusPassword);
			
			Repository.insertAccountsData(account, customer);
			

			System.out.println("\n-------------------------  Registration Successfull  -------------------------");
		}

	}
}
