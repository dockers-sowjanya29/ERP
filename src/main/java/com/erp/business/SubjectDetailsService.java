package com.erp.business;

import java.util.List;

import com.erp.dto.NameValuePair;
import com.erp.dto.SubjectDetailsRequest;
import com.erp.dto.SubjectDetailsResponse;


public interface SubjectDetailsService {
	
	public String saveSubjectDetails(SubjectDetailsRequest subjectDetailsRequest);
	
	public List<NameValuePair> getSubjectNamesList();
	
	public List<SubjectDetailsResponse> getSubjectDetailsList();

}
