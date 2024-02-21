package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.erp.business.SectionDetailsService;
import com.erp.dto.SectionDetailsRequest;

@RestController
@RequestMapping("controller/erp/sectionDetails")
public class SectionDetailsController {
	
	@Autowired
	SectionDetailsService sectionDetailsService;
	

	@RequestMapping(value = "/saveSectionDetails", method = RequestMethod.POST)
	public String saveSectionDetails(@RequestBody SectionDetailsRequest sectionDetailsRequest) {
		return sectionDetailsService.saveSectionDetails(sectionDetailsRequest);
	}

}
