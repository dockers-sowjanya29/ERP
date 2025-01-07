package com.erp.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	

	@Column(name="student_id")
	private String className;
	
	@Column(name="total_amount")
	private String classAliasName;
	
	@Column(name="amount_paid")
	private String classDescription;
	
	@Column(name="paid_date")
	private Calendar paid_date;
	
	@Column(name="next_due_date")
	private Calendar next_due_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassAliasName() {
		return classAliasName;
	}

	public void setClassAliasName(String classAliasName) {
		this.classAliasName = classAliasName;
	}

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

	public Calendar getPaid_date() {
		return paid_date;
	}

	public void setPaid_date(Calendar paid_date) {
		this.paid_date = paid_date;
	}

	public Calendar getNext_due_date() {
		return next_due_date;
	}

	public void setNext_due_date(Calendar next_due_date) {
		this.next_due_date = next_due_date;
	}
	
	
	
}
