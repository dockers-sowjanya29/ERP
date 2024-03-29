package com.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name ="subject_details") 
public class SubjectDetails {
	

	@Id
	@Column(name="SUBJECT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBJECT_ID_SEQUENCE")
	@SequenceGenerator(name = "SUBJECT_ID_SEQUENCE", sequenceName = "SUBJECT_ID_SEQUENCE", allocationSize = 1)
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
