package com.erp.dto;

public class SectionDetailsRequest {
	
    private Long id;
	
	private String classId;
	
	private String sectionName;
	
	private String sectionAliasName;
	
	private String sectionDescription;
	
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

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	private int strength;

}
