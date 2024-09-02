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
@Table (name="Student_details")
public class StudentDetails {
	
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_ID_SEQUENCE")
	@SequenceGenerator(name = "STUDENT_ID_SEQUENCE", sequenceName = "STUDENT_ID_SEQUENCE", allocationSize = 1)
	private Long id;
	
		
	 @Lob
	 @Column(name = "Profile_photo", length = 1000)
	 private  byte[] ProfilePhoto;	
	
	 @Column(name="Student_Name")
	 private String StudentName;

	 @Column(name="Age")
	 private int age;
	 
	 @Column(name="Blood_Group")
	 private String bloodGroup;
	 
	 @Column(name="City")
	 private String city;
	 
	 @Column(name="DOB")
	 private Calendar dob;
	 
	 @Lob
	 @Column(name = "Document_Photo", length = 1000)
	 private  byte[] DocumentPhoto;	
	 
	 @Column(name="Document_Name")
	 private String documentName;
	 
	 @Column(name="Document_number")
	 private int documentNo;
	 
	 @Column(name="Father_Name")
	 private String fatherName;
	 
	 @Column(name="Mother_Name")
	 private String motherName;
	 
	 @Column(name="Contact_no")
	 private String ContactNo;
	 
	 @Column(name="Email_ID")
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

	@Column(name="class_id")
	 private int classId;
	 
	 @Column(name="SECTION_NAME")
	 private int sectionId;
	


}
