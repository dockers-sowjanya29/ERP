package com.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="class_details")
public class ClassDetails {
	
	@Id
	@Column(name="CLASS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLASS_ID_SEQUENCE")
	@SequenceGenerator(name = "CLASS_ID_SEQUENCE", sequenceName = "CLASS_ID_SEQUENCE", allocationSize = 1)
	private Long id;
	

	@Column(name="CLASS_NAME")
	private String className;
	
	@Column(name="CLASS_ALIASNAME")
	private String classAliasName;
	
	@Column(name="CLASS_DESCRIPTION")
	private String classDescription;


	public Long getId() {
		return id;
	}

	
	public String getClassAliasName() {
		return classAliasName;
	}


	public void setClassAliasName(String classAliasName) {
		this.classAliasName = classAliasName;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}
	
     

}
