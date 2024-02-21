package com.erp.dto;

import javax.persistence.Column;

public class SubjectDetailsResponse {
	
	@Column(name ="SUBJECT_ID")
	private Long  id; 
	
	@Column(name ="SUBJECT_NAME")
	private String subjectName;
	  
	
	@Column(name ="SUBJECT_ALIASNAME")
	private String subjectAliasName;
	   
	
	@Column(name ="SUBJECT_DESCRIPTION")
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
