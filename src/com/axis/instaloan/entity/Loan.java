package com.axis.instaloan.entity;

import java.sql.Date;

public class Loan {
	private int customerId;
	private int loanId;
	private String loanType;
	private double loanAmount;
	private float interestRate;
	private String startDate;
	private String endDate;
	private int loanTenure;
	private double emi;
	private double balanceAmount;
	private double totalLoanAmount;
	
	

	public Loan(int customerId, String loanType, double loanAmount, float interestRate, String startDate,
			String endDate, int loanTenure, double emi, double balanceAmount, double totalLoanAmount) {
		super();
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.loanTenure = loanTenure;
		this.emi = emi;
		this.balanceAmount = balanceAmount;
		this.totalLoanAmount = totalLoanAmount;
	}

	public Loan() {
		// TODO Auto-generated constructor stub
	}

	

	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(long emi) {
		this.emi = emi;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balance) {
		this.balanceAmount = balance;
	}

	public double getTotalLoanAmount() {
		return totalLoanAmount;
	}

	public void setTotalLoanAmount(long totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}

}
