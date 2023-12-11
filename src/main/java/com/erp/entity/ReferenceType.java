package com.erp.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reference_type")
public class ReferenceType {
	
		
		@Id
		@Column(name="REF_TYPE_ID")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@Column(name="REF_TYPE_CODE")
		private String refTypeCode;
		
		@Column(name="REF_TYPE_DESC")
		private String refTypeDesc;
		
		@Column(name="CREATED_DATE")
		private Calendar createdDate;
		
		
		@Column(name="UPDATED_DATE")
		private Calendar updatedDate;
		
		@Column(name="EXPIRY_DATE")
		private Calendar expiryDate;

		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getRefTypeCode() {
			return refTypeCode;
		}

		public void setRefTypeCode(String refTypeCode) {
			this.refTypeCode = refTypeCode;
		}

		public String getRefTypeDesc() {
			return refTypeDesc;
		}

		public void setRefTypeDesc(String refTypeDesc) {
			this.refTypeDesc = refTypeDesc;
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
