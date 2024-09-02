package com.erp.dto;

import java.util.Calendar;

public class StudentDetailsResponse {
	
	 private Long id;
	 private  byte[] ProfilePhoto;	
	 private String StudentName;
	 private int age;
	 private String bloodGroup;
	 private String city;
	 private Calendar dob;
	 private  byte[] DocumentPhoto;	
     private String documentName;
	 private int documentNo;
	 private String fatherName;
     private String motherName;
     private String ContactNo;
	 private String emailId;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getProfilePhoto() {
		return ProfilePhoto;
	}
	public void setProfilePhoto(byte[] profilePhoto) {
		ProfilePhoto = profilePhoto;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Calendar getDob() {
		return dob;
	}
	public void setDob(Calendar dob) {
		this.dob = dob;
	}
	public byte[] getDocumentPhoto() {
		return DocumentPhoto;
	}
	public void setDocumentPhoto(byte[] documentPhoto) {
		DocumentPhoto = documentPhoto;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public int getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(int documentNo) {
		this.documentNo = documentNo;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
