package com.erp.business;

import java.util.List;

import com.erp.dto.NameValuePair;
import com.erp.dto.ReferenceDataResponse;

public interface ReferenceDataService {

	  public List<NameValuePair> getReferenceDataByRefTypeId(Long refId);
	
	  public List<NameValuePair> getRefDataByRefTypeCode(String refTypeCode);
			
}
