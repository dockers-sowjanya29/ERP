package com.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SECTION_DETAILS")
public class SectionDetails {
	
	
	@Id
	@Column(name="SECTION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECTION_ID_SEQUENCE")
	@SequenceGenerator(name = "SECTION_ID_SEQUENCE", sequenceName = "SECTION_ID_SEQUENCE", allocationSize = 1)
	private Long id;
	
	@Column(name="CLASS_ID")
	private Long classId;
	
	@Column(name="SECTION_NAME")
	private String sectionName;
	
	@Column(name="SECTION_ALIASNAME")
	private String sectionAliasName;
	
	@Column(name="SECTION_DESCRIPTION")
	private String sectionDescription;
	

	 @Column(name="STRENGTH")
	 private int strength;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	


	public Long getClassId() {
		return classId;
	}


	public void setClassId(Long classId) {
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
	 
	 

	
	
	


}
