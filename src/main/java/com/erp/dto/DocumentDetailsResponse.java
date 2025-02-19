package com.erp.dto;

public class DocumentDetailsResponse {

	private Long id;
	private String documentName;
	private String documentNo;
	private byte[] documentPhoto;
	private Long studentId;
	private byte[] documentIdetificationPhoto;

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

	public byte[] getDocumentIdetificationPhoto() {
		return documentIdetificationPhoto;
	}

	public void setDocumentIdetificationPhoto(byte[] documentIdetificationPhoto) {
		this.documentIdetificationPhoto = documentIdetificationPhoto;
	}

}
