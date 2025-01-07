package com.erp.dto;

import java.util.Calendar;



public class FeeDetailsRequest {
	
	private String className;
	private String classAliasName;
	private String classDescription;
	private Calendar paid_date;
	private Calendar next_due_date;
	
	
	
	private Long id;
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
