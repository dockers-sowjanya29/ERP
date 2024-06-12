package com.erp.dto;

public class SubjectDetailsResponse {

	private Long id;

	private String subjectName;

	private String subjectAliasName;

	private String subjectDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectAliasName() {
		return subjectAliasName;
	}

	public void setSubjectAliasName(String subjectAliasName) {
		this.subjectAliasName = subjectAliasName;
	}

	public String getSubjectDescription() {
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

}
