package com.axis.instaloan.sevices;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.axis.instaloan.repo.Repository;

public class UpdateDetails {
	
	public void update() throws SQLException {
		Scanner sc = new Scanner(System.in);
	    System.out.println("\nUPDATE User Details:");
	    System.out.println("[1] Full Name");
	    System.out.println("[2] Email");
	    System.out.println("[3] Phone");
	    System.out.println("[4] CibilScore");
	    System.out.print("Enter your choice (1-4): ");
	    int choice = sc.nextInt();
	    sc.nextLine();
		
		int updateStatus = Repository.userUpdate(choice);
		
		if (updateStatus > 0) {
	        System.out.println("\n--------------- Record Updated Successfully ---------------");
	    } else {
	        System.out.println("-------------------   Update failed   -------------------");
	    }
	}

}
