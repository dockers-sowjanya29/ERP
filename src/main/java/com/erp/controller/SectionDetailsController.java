package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.business.SectionDetailsService;
import com.erp.dto.NameValuePair;
import com.erp.dto.SectionDetailsRequest;
import com.erp.dto.SectionDetailsResponse;

@RestController
@RequestMapping("controller/erp/sectionDetails")
public class SectionDetailsController {
	
	@Autowired
	SectionDetailsService sectionDetailsService;
	

	@RequestMapping(value = "/saveSectionDetails", method = RequestMethod.POST)
	public String saveSectionDetails(@RequestBody SectionDetailsRequest sectionDetailsRequest) {
		return sectionDetailsService.saveSectionDetails(sectionDetailsRequest);
	}
	
	@RequestMapping(value = "/getSectionDetailsList", method = RequestMethod.GET)
	public List<SectionDetailsResponse> getSectionDetailsList() {
		return sectionDetailsService.getSectionDetailsList();
	}
	
	@RequestMapping(value = "/getSectionNamesList", method = RequestMethod.GET)
	public List<NameValuePair> getSectionNamesList() {
		return sectionDetailsService.getSectionNamesList();
	}
	
	@RequestMapping(value = "/getSectionNamesListByClassId", method = RequestMethod.POST)
	public List<NameValuePair> getSectionNamesListByClassId(@RequestBody Long classId) {
		return sectionDetailsService.getSectionNamesListByClassId(classId);
	}

}
