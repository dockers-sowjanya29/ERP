package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.business.impl.ReferenceDataServiceImpl;
import com.erp.dto.NameValuePair;

@RestController
@RequestMapping("controller/erp/reference")
public class ReferenceController {
	
	@Autowired
	ReferenceDataServiceImpl referenceDataImpl;
	
	@RequestMapping(value="/getReferenceDataByRefTypeId", method=RequestMethod.GET)
	public List<NameValuePair> getReferenceDataByRefTypeId(@RequestBody Long refTypeId) { //JSOn
		
		return referenceDataImpl.getReferenceDataByRefTypeId(refTypeId);
	}
	
	
	@RequestMapping(value="/getReferenceDataByRefTypeCode", method=RequestMethod.POST)
	public List<NameValuePair> getReferenceDataByRefTypeCode(@RequestBody String refTypeCode) { //JSOn
		
		return referenceDataImpl.getRefDataByRefTypeCode(refTypeCode);
	}

}
