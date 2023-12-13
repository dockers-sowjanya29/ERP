package com.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "role_features")
public class RoleFeature {

	@Id
	@Column(name = "ROLE_FEATURE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_FEATURE_ID_SEQUENCE")
	@SequenceGenerator(name = "ROLE_FEATURE_ID_SEQUENCE", sequenceName = "ROLE_FEATURE_ID_SEQUENCE", allocationSize = 1)
	private Long id;

	@Column(name = "SCHOOL_ROLE_ID")
	private Long schoolRoleId;

	@Column(name = "FEATURE_REF_ID")
	private Long featureRefId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSchoolRoleId() {
		return schoolRoleId;
	}

	public void setSchoolRoleId(Long schoolRoleId) {
		this.schoolRoleId = schoolRoleId;
	}

	public Long getFeatureRefId() {
		return featureRefId;
	}

	public void setFeatureRefId(Long featureRefId) {
		this.featureRefId = featureRefId;
	}

}
