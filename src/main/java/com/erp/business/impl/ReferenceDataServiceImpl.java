package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.ReferenceDataService;
import com.erp.dto.NameValuePair;
import com.erp.entity.ReferenceData;
import com.erp.entity.ReferenceDataLang;
import com.erp.repository.ReferenceDataLangRepository;
import com.erp.repository.ReferenceDataRepository;
import com.erp.util.ErpConstants;

@Service
public class ReferenceDataServiceImpl implements ReferenceDataService{

	
	@Autowired 
	ReferenceDataRepository referenceDataRepository;
	
	@Autowired
	ReferenceTypeServiceImpl referenceTypeServiceImpl;
	
	
	@Autowired
	ReferenceDataLangRepository referenceDataLangRepository;
	
	
	@Override
	public List<NameValuePair> getReferenceDataByRefTypeId(Long refId) {
		List<ReferenceData>  refDataList=referenceDataRepository.findAllByRefTypeId(refId);
		List<NameValuePair> refDataReponseList =null;
		
		
		if(refDataList!=null)
		{
			refDataReponseList=new ArrayList<NameValuePair>();
			for(ReferenceData refData : refDataList)
			{
				if(refData!=null & refData.getExpiryDate()==null)
				{
					NameValuePair refDataResponse=new NameValuePair();
					ReferenceDataLang referenceDataLang= referenceDataLangRepository.findByRefDataIdAndLangType(refData.getId(), ErpConstants.DEFAULT_LANG_TYPE);
					if(referenceDataLang!=null) {
						refDataResponse.setName(referenceDataLang.getRefDataLabel());
						refDataResponse.setValue(refData.getId().toString());
					}
					else {
						refDataResponse.setName(refData.getRefDataCode());
						refDataResponse.setValue(refData.getId().toString());
					}
					refDataReponseList.add(refDataResponse);
					
					
				}
			}
			
		}
		return refDataReponseList;
	}
	
	@Override
    public List<NameValuePair> getRefDataByRefTypeCode(String refTypeCode) {
		
		Long refTypeId=referenceTypeServiceImpl.getRefTypeCode(refTypeCode);
		
		return getReferenceDataByRefTypeId(refTypeId);
	}
	
	

}
