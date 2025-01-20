package com.erp.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="Student_details")
public class StudentDetails {
	
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_ID_SEQUENCE")
	@SequenceGenerator(name = "STUDENT_ID_SEQUENCE", sequenceName = "STUDENT_ID_SEQUENCE", allocationSize = 1)
	private Long id;
	
		
	 @Lob
	 @Column(name = "Profile_photo", length = 1000)
	 private  byte[] profilePhoto;	
	
	 @Column(name="Student_Name")
	 private String studentName;

	 

	@Column(name="Age")
	 private int age;
	 
	 @Column(name="Blood_Group")
	 private String bloodGroupName;
	 
	 @Column(name="City")
	 private String city;
	 
	 @Column(name="DOB")
	 private Calendar dob;
	 
	 @Lob
	 @Column(name = "Document_Photo", length = 1000)
	 private  byte[] documentPhoto;	
	 
	 @Column(name="Father_Name")
	 private String fatherName;
	 
	 @Column(name="Mother_Name")
	 private String motherName;
	 
	 @Column(name="Contact_no")
	 private String contactNo;
	 
	 @Column(name="Email_ID")
	 private String emailId;
	 
	 @Column(name="class_id")
	 private int classId;
	 
	 @Column(name="SECTION_ID")
	 private int sectionId;
	 
	 
	 @OneToMany(mappedBy = "studentDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
		private List<FeeDetails>  feeDetails= new ArrayList<>();	
	 
	 
	 public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public byte[] getDocumentPhoto() {
		return documentPhoto;
	}

	public void setDocumentPhoto(byte[] documentPhoto) {
		this.documentPhoto = documentPhoto;
	}

	@Column(name="Document_Name")
	 private String documentName;
	 
	 @Column(name="Document_number")
	 private int documentNo;
	 
	 public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	
	 
	 
	 public List<FeeDetails> getFeeDetails() {
		return feeDetails;
	}

	public void setFeeDetails(List<FeeDetails> feeDetails) {
		this.feeDetails = feeDetails;
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



	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	
	


}
