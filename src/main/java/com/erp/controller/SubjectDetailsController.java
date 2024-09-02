package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.business.SubjectDetailsService;
import com.erp.dto.NameValuePair;
import com.erp.dto.SubjectDetailsRequest;
import com.erp.dto.SubjectDetailsResponse;

@RestController
@RequestMapping("controller/erp/subjectDetails")
public class SubjectDetailsController {

	
	@Autowired
	SubjectDetailsService subjectDetailsService;
	

	@RequestMapping(value = "/saveSubjectDetails", method = RequestMethod.POST)
	public String saveSubjectDetails(@RequestBody SubjectDetailsRequest subjectDetailsRequest) {
		return subjectDetailsService.saveSubjectDetails(subjectDetailsRequest);
	}
	
	@RequestMapping(value = "/getSubjectDetailsList", method = RequestMethod.GET)
	public List<SubjectDetailsResponse> getSubjectDetailsList() {
		return subjectDetailsService.getSubjectDetailsList();
	}
	
	@RequestMapping(value = "/getSubjectNamesList", method = RequestMethod.GET)
	public List<NameValuePair> getSubjectNamesList() {
		return subjectDetailsService.getSubjectNamesList();
	}
	
	
}
