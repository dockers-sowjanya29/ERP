package com.erp.dto;

public class RoleRequest {
	
	private Long id;
	private Long schoolId;
	private Long roleRefId;
	private Long features[];
	private String userName;
	private Long phoneNumber;
	private String password;
	
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
	public Long[] getFeatures() {
		return features;
	}
	public void setFeatures(Long[] features) {
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
