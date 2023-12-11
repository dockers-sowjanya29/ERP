package com.erp.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.ReferenceTypeService;
import com.erp.entity.ReferenceType;
import com.erp.repository.ReferenceTypeRepository;

@Service
public class ReferenceTypeServiceImpl implements ReferenceTypeService{
	
	@Autowired
	ReferenceTypeRepository referenceTypeRepository;
	
	public Long getRefTypeCode(String refTypeCode) {
		
		ReferenceType referenceType=referenceTypeRepository.findByRefTypeCode(refTypeCode);
		
		if(referenceType!=null && referenceType.getExpiryDate()==null)
		{
			return referenceType.getId();
			
		}
		return null;
	}
	
 

}
