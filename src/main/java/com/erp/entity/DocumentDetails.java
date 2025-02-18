package com.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="document_details")
public class DocumentDetails {
	
	@Id
	@Column(name="doc_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENT_ID_SEQUENCE")
	@SequenceGenerator(name = "DOCUMENT_ID_SEQUENCE", sequenceName = "DOCUMENT_ID_SEQUENCE", allocationSize = 1)
	private Long id;
	
	
	@Column(name="document_name")
	private String documentName ;
	
	
	@Column(name="doc_no")
	private String documentNo ;
	
	 @Lob
	 @Column(name = "document_photo")
	 private  byte[] documentPhoto;	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "student_id")
	private StudentDetails studentDetails; 
	
		
	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}



	public byte[] getDocumentPhoto() {
		return documentPhoto;
	}

	public void setDocumentPhoto(byte[] documentPhoto) {
		this.documentPhoto = documentPhoto;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	

	
	
	
}
