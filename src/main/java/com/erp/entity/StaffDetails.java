package com.erp.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name ="staff")
public class StaffDetails {
	
	@Id
	@Column(name = "STAFF_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STAFF_ID_SEQUENCE")
	@SequenceGenerator(name = "STAFF_ID_SEQUENCE", sequenceName = "STAFF_ID_SEQUENCE", allocationSize = 1)
	private Long id;  
	
	@Column(name = "CATEGORY_ID")
	private Long categoryId;   
	
	@Column(name = "SUBJECT_ID")
	private Long subjectId ;
	
	@Column(name = "SECTION_ID")
	private Long sectionId;
	
	@Column(name = "CLASS_ID")
	private Long classId ; 
	
	 @Lob
	 @Column(name = "PROFILE_PHOTO", length = 1000)
	private byte[]  profilePhoto; 
	
	@Column(name = "STAFF_NAME")
	private String staffName;  
	
	@Column(name = "PHONE_NUMBER")
	private Long phoneNo; 
	
	@Column(name = "EMAIL_ID")
	private String emailId;  
	
	@Column(name = "STAFF_LOCATION")
	private String staffLocation; 
	
	@Column(name = "DOB")
	private Calendar dob ;

	@Column(name = "QUALIFICATION")
	private String qualification; 
	
	@Column(name = "EXPERIENCE")
	private String experience;
	
	@Column(name = "DOJ")
	private Calendar doj; 
	
	@Column(name = "SALARY")
	private Double salary; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStaffLocation() {
		return staffLocation;
	}

	public void setStaffLocation(String staffLocation) {
		this.staffLocation = staffLocation;
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Calendar getDoj() {
		return doj;
	}

	public void setDoj(Calendar doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

      

}
