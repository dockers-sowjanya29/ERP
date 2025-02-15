package com.erp.dto;

import java.util.Calendar;
import java.util.List;

public class StudentDetailsRequest {
	
	 private Long id;
	// private  byte[] profilePhoto;	
	 
	 private int age;
	 private String bloodGroupName;
	 private String city;
	 private int classId;
	 private String contactNo;
	 private Calendar dob;
	 //Document list
	 private List<DocumentDetailsRequest> documents;
	 private String emailId;
	 private String fatherName;
	 //Fee List
	 private List<FeeDetailsRequest> fees;
     private String motherName;
	 private int sectionId;
	 private String studentName;
	 private double totalAmount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Calendar getDob() {
		return dob;
	}
	public void setDob(Calendar dob) {
		this.dob = dob;
	}
	public List<DocumentDetailsRequest> getDocuments() {
		return documents;
	}
	public void setDocuments(List<DocumentDetailsRequest> documents) {
		this.documents = documents;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public List<FeeDetailsRequest> getFees() {
		return fees;
	}
	public void setFees(List<FeeDetailsRequest> fees) {
		this.fees = fees;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getBloodGroupName() {
		return bloodGroupName;
	}
	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}
	
	 


	 
	 

}
