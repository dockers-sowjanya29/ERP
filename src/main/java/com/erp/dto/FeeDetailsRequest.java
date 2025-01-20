package com.erp.dto;

import java.util.Calendar;



public class FeeDetailsRequest {
	
	private String className;
	private String classAliasName;
	private String classDescription;
	private Calendar paidDate;
	private Calendar nextDueDate;
	private Long id;
	
	
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


}
