package com.erp.dto;

import java.util.Calendar;

public class RoleResponse {

	private Long id;
	private Long schoolId;
	private Long roleRefId;
	private Long features;
	private String userName;
	private Long phoneNumber;
	private String password;
	private String roleText;
	private Calendar assignedDate;
	private Calendar lastLogin;
	
	public Long getId() {
		return id;
	}
	public String getRoleText() {
		return roleText;
	}
	public void setRoleText(String roleText) {
		this.roleText = roleText;
	}
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
	public Long getFeatures() {
		return features;
	}
	public void setFeatures(Long features) {
		this.features = features;
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
