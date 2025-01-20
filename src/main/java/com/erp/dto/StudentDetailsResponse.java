package com.erp.dto;

import java.util.Calendar;

public class StudentDetailsResponse {
	
	     private Long id;
		 private String studentName;
		 private int age;
		 private String bloodGroupName;
		 private String city;
		 private Calendar dob;
		 
		 private String documentName;
		 private int documentNo; 
		 private String fatherName;
	     private String motherName;
	     private String contactNo;
		
		 private String emailId;
		 private FeeDetailsRequest feeDetails;
		 private Calendar nextDueDate;
		 private Calendar paidDate;
		 private double totalAmount;
		 private double amountPaid; 
		 private int sectionId;
		 private int classId;
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
		public String getBloodGroupName() {
			return bloodGroupName;
		}
		public void setBloodGroupName(String bloodGroupName) {
			this.bloodGroupName = bloodGroupName;
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
			return contactNo;
		}
		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public FeeDetailsRequest getFeeDetails() {
			return feeDetails;
		}
		public void setFeeDetails(FeeDetailsRequest feeDetails) {
			this.feeDetails = feeDetails;
		}
		public Calendar getNextDueDate() {
			return nextDueDate;
		}
		public void setNextDueDate(Calendar nextDueDate) {
			this.nextDueDate = nextDueDate;
		}
		public Calendar getPaidDate() {
			return paidDate;
		}
		public void setPaidDate(Calendar paidDate) {
			this.paidDate = paidDate;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public double getAmountPaid() {
			return amountPaid;
		}
		public void setAmountPaid(double amountPaid) {
			this.amountPaid = amountPaid;
		}
		public int getSectionId() {
			return sectionId;
		}
		public void setSectionId(int sectionId) {
			this.sectionId = sectionId;
		}
		public int getClassId() {
			return classId;
		}
		public void setClassId(int classId) {
			this.classId = classId;
		}
	 
	

}
