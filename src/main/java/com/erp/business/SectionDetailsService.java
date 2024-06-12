package com.erp.business;

import java.util.List;

import com.erp.dto.NameValuePair;
import com.erp.dto.SectionDetailsRequest;
import com.erp.dto.SectionDetailsResponse;
import com.erp.dto.SubjectDetailsResponse;

public interface SectionDetailsService {
	
	public String saveSectionDetails(SectionDetailsRequest sectionDetailsRequest);

	public List<NameValuePair> getSectionNamesList();
	public List<SectionDetailsResponse> getSectionDetailsList();
}
