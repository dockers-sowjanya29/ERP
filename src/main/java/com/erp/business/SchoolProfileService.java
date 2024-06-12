package com.erp.business;

import java.util.List;

import com.erp.dto.NameValuePair;
import com.erp.dto.SchoolProfileRequest;
import com.erp.dto.SchoolProfileResponse;

public interface SchoolProfileService {
	
	public String saveSchoolDetails(SchoolProfileRequest schoolreq);
	
	public SchoolProfileResponse getSchoolDetailsById(Long schoolId);
	public SchoolProfileResponse getSchoolDetailsByName(String schoolName);
	public List<NameValuePair> loadSchools();
	public SchoolProfileResponse updateSchool(SchoolProfileRequest schoolProfileRequest);
	public SchoolProfileResponse deactiveSchool(Long schoolId);
	public SchoolProfileResponse activateSchool(Long schoolId);

}
