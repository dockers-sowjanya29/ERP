package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.erp.business.SubjectDetailsService;
import com.erp.dto.SubjectDetailsRequest;

@RestController
@RequestMapping("controller/erp/subjectDetails")
public class SubjectDetailsController {

	
	@Autowired
	SubjectDetailsService subjectDetailsService;
	

	@RequestMapping(value = "/saveSubjectDetails", method = RequestMethod.POST)
	public String saveSubjectDetails(@RequestBody SubjectDetailsRequest subjectDetailsRequest) {
		return subjectDetailsService.saveSubjectDetails(subjectDetailsRequest);
	}
}
