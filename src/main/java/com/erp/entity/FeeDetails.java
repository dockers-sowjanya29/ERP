package com.erp.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="fee_details")
public class FeeDetails {
	
	@Id
	@Column(name="FEE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FEE_ID_SEQUENCE")
	@SequenceGenerator(name = "FEE_ID_SEQUENCE", sequenceName = "FEE_ID_SEQUENCE", allocationSize = 1)
	private Long id;
	

	//@Column(name="student_id")
	//private String studentId;
	
	@Column(name="total_amount")
	private double totalAmount;
	
	@Column(name="amount_paid")
	private double amountPaid;
	
	@Column(name="paid_date")
	private Calendar paidDate;
	
	@Column(name="next_due_date")
	private Calendar nextDueDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "student_id")
	private StudentDetails studentDetails; 
	
	
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Calendar getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Calendar paidDate) {
		this.paidDate = paidDate;
	}

	public Calendar getNextDueDate() {
		return nextDueDate;
	}

	public void setNextDueDate(Calendar nextDueDate) {
		this.nextDueDate = nextDueDate;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	
	
	
}
