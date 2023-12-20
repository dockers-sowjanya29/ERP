package com.erp.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "school_roles")
public class Role {

	@Id
	@Column(name = "SCHOOL_ROLE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHOOL_ROLE_ID_SEQUENCE")
	@SequenceGenerator(name = "SCHOOL_ROLE_ID_SEQUENCE", sequenceName = "SCHOOL_ROLE_ID_SEQUENCE", allocationSize = 1)
	private Long id;

	
	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<RoleFeature> roleFeatures = new ArrayList<>();	
	
	public List<RoleFeature> getRoleFeatures() {
		return roleFeatures;
	}

	public void setRoleFeatures(List<RoleFeature> roleFeatures) {
		this.roleFeatures = roleFeatures;
	}

	@Column(name = "SCHOOL_ID")
	private Long schoolId;

	@Column(name = "ROLE_REF_ID")
	private Long roleRefId;

		

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PHONENUMBER")
	private Long phoneNumber;

	@Column(name = "PWD")
	private String password;
	
	@Column(name = "Assigned_date")
	private Calendar assignedDate;
	
	@Column(name = "Last_Login")
	private Calendar lastLogin;
	

	public Calendar getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Calendar assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Calendar getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Calendar lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public Long getRoleRefId() {
		return roleRefId;
	}

	public void setRoleRefId(Long roleRefId) {
		this.roleRefId = roleRefId;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
