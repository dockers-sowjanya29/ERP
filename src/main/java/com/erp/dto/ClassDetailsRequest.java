package com.erp.dto;

public class ClassDetailsRequest {
	
	
      private Long id;
	  private String className;
	
	  private String classAliasName;
	
	  private String classDescription;

	public Long getId() {
		return id;
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

	public String getClassAliasName() {
		return classAliasName;
	}

	public void setClassAliasName(String classAliasName) {
		this.classAliasName = classAliasName;
	}

	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

}
