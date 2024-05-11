package com.axis.instaloan.entity;

public class EmiPayment {

	private int paymentId;
	private double paymentAmount;
	private String paymentDateTime;
	private String status;
	private int customerId;

	public EmiPayment() {
		super();
	}

	public EmiPayment(double paymentAmount, String paymentDateTime, String status) {
		super();
		this.paymentAmount = paymentAmount;
		this.paymentDateTime = paymentDateTime;
		this.status = status;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(long paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(String paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
