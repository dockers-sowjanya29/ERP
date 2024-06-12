package com.erp.business;

import java.util.List;

import com.erp.dto.ClassDetailsRequest;
import com.erp.dto.ClassDetailsResponse;
import com.erp.dto.NameValuePair;

public interface ClassDetailsService {
	
	public String saveClassDetails(ClassDetailsRequest classDetailsRequest);
	public List<ClassDetailsResponse> getClassDetailsList();
	public List<NameValuePair> getClassNamesList();
	public boolean deleteClassDetails(Long id);

}
