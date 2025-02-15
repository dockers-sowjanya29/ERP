package com.erp.dto;

import java.util.Calendar;
import java.util.List;

public class StudentDetailsResponse {
	
	 private Long id;
	 private String studentName;
	 private int age;
	 private String bloodGroup;
	 private String city;
	 private Calendar dob;
	 private String fatherName;
     private String motherName;
     private String contactNo;
	 private String emailId;
	 private long sectionId;
	 private long classId;
	 private String feeStatus;  //fee status
	 
	 private String className;
	 private String sectionName;
	 
	 
	 //Fee List
	 private List<FeeDetailsResponse> fees;
	 private double totalAmount;
	 
	 //Document list
	 private List<DocumentDetailsResponse> documents;

	 public List<FeeDetailsResponse> getFees() {
			return fees;
		}
		public void setFees(List<FeeDetailsResponse> fees) {
			this.fees = fees;
		}
	 
	
	 
	 public String getContactNo() {
			return contactNo;
		}
		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}
		
		

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	 
		public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	public Calendar getDob() {
		return dob;
	}
	public void setDob(Calendar dob) {
		this.dob = dob;
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

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<DocumentDetailsResponse> getDocuments() {
		return documents;
	}
	public void setDocuments(List<DocumentDetailsResponse> documents) {
		this.documents = documents;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getFeeStatus() {
		return feeStatus;
	}
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}
	public void setClassId(long classId) {
		this.classId = classId;
	}


}
