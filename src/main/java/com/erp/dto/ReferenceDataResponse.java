package com.erp.dto;

import java.util.Calendar;

public class ReferenceDataResponse {

	private Long id;
	private Long refTypeID;
	private String refDataCode;
	private String refDataDesc;
	private Calendar createdDate;
	private Calendar updatedDate;
	private Calendar expiryDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRefTypeID() {
		return refTypeID;
	}

	public void setRefTypeID(Long refTypeID) {
		this.refTypeID = refTypeID;
	}

	public String getRefDataCode() {
		return refDataCode;
	}

	public void setRefDataCode(String refDataCode) {
		this.refDataCode = refDataCode;
	}

	public String getRefDataDesc() {
		return refDataDesc;
	}

	public void setRefDataDesc(String refDataDesc) {
		this.refDataDesc = refDataDesc;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Calendar getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Calendar expiryDate) {
		this.expiryDate = expiryDate;
	}

}
