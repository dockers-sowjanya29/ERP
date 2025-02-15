package com.erp.dto;

import java.util.Calendar;



public class FeeDetailsRequest {
	
	private double amountPaid;
	private Calendar nextDueDate;
	private Calendar paidDate;
	private double totalAmount;
	
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	private Long id;

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Calendar getNextDueDate() {
		return nextDueDate;
	}

	public void setNextDueDate(Calendar nextDueDate) {
		this.nextDueDate = nextDueDate;
	}

	public Calendar getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Calendar paidDate) {
		this.paidDate = paidDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	




}
