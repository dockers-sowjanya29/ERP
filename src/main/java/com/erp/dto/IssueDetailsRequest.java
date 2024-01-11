package com.erp.dto;

import java.util.Calendar;

public class IssueDetailsRequest {
	

	private Long id;
	private Long inventoryId;
	private String issueTo;
	private Calendar issueDate;
	private Float quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getIssueTo() {
		return issueTo;
	}
	public void setIssueTo(String issueTo) {
		this.issueTo = issueTo;
	}
	public Calendar getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Calendar issueDate) {
		this.issueDate = issueDate;
	}
	public Float getQuantity() {
		return quantity;
	}
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	
	

}
