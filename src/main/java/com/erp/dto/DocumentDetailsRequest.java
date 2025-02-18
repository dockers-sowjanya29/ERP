package com.erp.dto;

public class DocumentDetailsRequest {
	
	private Long id;
	private String documentName ;
	private String documentNo ;
	private FileDTO documentIdetificationPhoto;
	//private  String documentPhoto;	
	private Long studentId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	public FileDTO getDocumentIdetificationPhoto() {
		return documentIdetificationPhoto;
	}
	public void setDocumentIdetificationPhoto(FileDTO documentIdetificationPhoto) {
		this.documentIdetificationPhoto = documentIdetificationPhoto;
	}
	
	

}
