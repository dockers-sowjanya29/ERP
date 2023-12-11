package com.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="school_details")
public class School {
	
	
	@Id
	@Column(name = "SCHOOL_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHOOL_ID_SEQUENCE")
	@SequenceGenerator(name = "SCHOOL_ID_SEQUENCE",sequenceName = "SCHOOL_ID_SEQUENCE", allocationSize = 1)
	private Long id;
	
	
	
	 @Lob
	 @Column(name = "LOGO", length = 1000)
	//private byte[] imageData;
	private  byte[] logo;
	
	
	@Column(name="SCHOOL_NAME")
	private String schoolName;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="CONTACTNUMBER")
	private Long contactNo;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="WEBSITE")
	private String website;
	
	@Column(name="STATUS")
	private String status;
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public  byte[] getLogo() {
		return logo;
	}

	public void setLogo( byte[] logo) {
		this.logo = logo;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	
	
	
	

}
