package com.erp.business;

import java.util.List;

import com.erp.dto.NameValuePair;
import com.erp.dto.SchoolRequest;
import com.erp.dto.SchoolResponse;

public interface SchoolService {
	
	public String saveSchoolDetails(SchoolRequest schoolreq);
	
	public SchoolResponse getSchoolDetailsById(Long schoolId);
	public SchoolResponse getSchoolDetailsByName(String schoolName);
	public List<NameValuePair> loadSchools();
	public SchoolResponse updateSchool(SchoolRequest schoolRequest);
	public SchoolResponse deactiveSchool(Long schoolId);
	public SchoolResponse activateSchool(Long schoolId);

}
