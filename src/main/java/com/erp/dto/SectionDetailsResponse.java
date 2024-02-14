package com.erp.dto;

public class SectionDetailsResponse {
	
    private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionAliasName() {
		return sectionAliasName;
	}

	public void setSectionAliasName(String sectionAliasName) {
		this.sectionAliasName = sectionAliasName;
	}

	public String getSectionDescription() {
		return sectionDescription;
	}

	public void setSectionDescription(String sectionDescription) {
		this.sectionDescription = sectionDescription;
	}

	private String classId;
	
	private String sectionName;
	
	private String sectionAliasName;
	
	private String sectionDescription;

}
