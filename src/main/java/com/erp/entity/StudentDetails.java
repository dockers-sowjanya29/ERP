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
	 private String bloodGroup;
	 
	 @Column(name="City")
	 private String city;
	 
	 @Column(name="DOB")
	 private Calendar dob;
	 
	 
	 @Column(name="Father_Name")
	 private String fatherName;
	 
	 @Column(name="Mother_Name")
	 private String motherName;
	 
	 @Column(name="Contact_no")
	 private String contactNo;
	 
	 @Column(name="Email_ID")
	 private String emailId;
	 
	 @Column(name="class_id")
	 private Long classId;
	 
	 @Column(name="SECTION_ID")
	 private Long sectionId;
	 
		 
	 
	 @OneToMany(mappedBy = "studentDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
		private List<FeeDetails>  feeDetails= new ArrayList<>();	
	 
	 
	 @OneToMany(mappedBy = "studentDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
		private List<DocumentDetails>  documentDetails= new ArrayList<>();
	 
	 
	 public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	
	 
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



	public List<DocumentDetails> getDocumentDetails() {
		return documentDetails;
	}

	public void setDocumentDetails(List<DocumentDetails> documentDetails) {
		this.documentDetails = documentDetails;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	
	


}
