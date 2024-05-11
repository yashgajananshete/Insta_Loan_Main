package com.axis.instaloan.entity;

public class Customer {
	private int customerId;
	private String fullName;
	private String dob;
	private String gender;
	private long mobileNumber;
	private String email;
	private String panNumber;
	private long aadharNumber;
	private long accountNumber;
	private int cibilScore;

	public int getCustomerId() {
		return customerId;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", dob=" + dob + ", email=" + email
				+ ", panNumber=" + panNumber + ", aadharNumber=" + aadharNumber + ", accountNumber=" + accountNumber
				+ ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", cibilScore=" + cibilScore + "]";
	}

	public Customer(int customerId, String fullName, String dob, String email, String panNumber, long aadharNumber,
			long accountNumber, String gender, long mobileNumber, int cibilScore) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.dob = dob;
		this.email = email;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.accountNumber = accountNumber;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.cibilScore = cibilScore;
	}
//	public Customer(int int1, String string, String string2, String string3, long long1, long long2, long long3,
//			String string4, long long4, int int2) {
//		// TODO Auto-generated constructor stub
//	}
	
	public Customer(String fullName, String dob, String email, String panNumber, long aadharNumber,
			long accountNumber, String gender, long mobileNumber, int cibilScore) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.email = email;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.accountNumber = accountNumber;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.cibilScore = cibilScore;
	}

	

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
}
