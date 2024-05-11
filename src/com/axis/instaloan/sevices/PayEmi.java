package com.axis.instaloan.sevices;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.axis.instaloan.entity.EmiPayment;
import com.axis.instaloan.entity.Loan;
import com.axis.instaloan.repo.Repository;

public class PayEmi {
	public void payEmiForTheLoan() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPaying the emi for the loan");
        
        System.out.print("\nEnter the amount: ");
        int amount = scanner.nextInt();
        
        String datetime = String.valueOf(LocalDateTime.now());
                
        EmiPayment emiPay = new EmiPayment(amount, datetime, "Success");
        
        Repository.insertEmiPaymentData(emiPay);
        
        ResultSet rs = Repository.displayCustomersAllData();
        
        Loan loan = Repository.loanObjData();
        
        double balance = loan.getTotalLoanAmount() - amount;
        
        loan.setBalanceAmount(balance);
        
        Repository.updateBalanceAmount(balance);
        
        System.out.println("EMI successfully paid the amount of " + amount + " for the CustomerId : " + rs.getInt("CustomerID") + ", UserName : " + rs.getString("FullName") + ", userEmail : " + rs.getString("Email"));
        
        
    }

}
