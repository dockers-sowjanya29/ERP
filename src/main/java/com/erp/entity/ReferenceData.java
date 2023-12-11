package com.erp.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="reference_data")
public class ReferenceData {
	
		
		@Id
		@Column(name="REF_DATA_ID")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		//@Id
		@Column(name="REF_TYPE_ID")
		//@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long refTypeId;
		
		@Column(name="REF_DATA_CODE")
		private String refDataCode;
		
		@Column(name="REF_DATA_DESC")
		private String refDataDesc;
		
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

		public Long getRefTypeId() {
			return refTypeId;
		}

		public void setRefTypeID(Long refTypeID) {
			this.refTypeId = refTypeID;
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
