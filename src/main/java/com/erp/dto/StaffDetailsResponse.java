package com.erp.dto;

import java.util.Calendar;

public class StaffDetailsResponse {
	
	
	private Long id;
	private Long categoryId;
	private Long subjectId[];
	

	private Long sectionId[];
	private Long classId[];
	private byte[] profilePhoto;
	private String staffName;
	private Long phoneNo;
	private String emailId;
	private String staffLocation;
	private Calendar dob;
	private String qualification;
	private String experience;
	

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
	
	
	public Long[] getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long[] subjectId) {
		this.subjectId = subjectId;
	}

	public Long[] getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long[] sectionId) {
		this.sectionId = sectionId;
	}

	public Long[] getClassId() {
		return classId;
	}

	public void setClassId(Long[] classId) {
		this.classId = classId;
	}

}
