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
@Table(name="Issue_details")
public class IssueDetails {
	
	@Id
	@Column(name = "Issue_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISSUE_ID_SEQUENCE")
	@SequenceGenerator(name = "ISSUE_ID_SEQUENCE", sequenceName = "ISSUE_ID_SEQUENCE", allocationSize = 1)
	private Long id;
	
	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "Inventory_id")
	private Long  inventoryId;
	
	public Long getInventoryId() {
		return inventoryId;
	}


	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}


	@Column(name = "Issue_to")
	private String issueTo;


	@Column(name = "Issue_date")
	private Calendar issueDate;
	
	
	@Column(name = "quantity")
	private Float quantity;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
