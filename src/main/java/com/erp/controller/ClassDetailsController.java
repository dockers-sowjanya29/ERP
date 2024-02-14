package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.erp.business.ClassDetailsService;
import com.erp.dto.ClassDetailsRequest;
import com.erp.dto.ClassDetailsResponse;
import com.erp.dto.NameValuePair;

@RestController
@RequestMapping("controller/erp/classDetails")
public class ClassDetailsController {
	
	@Autowired
	ClassDetailsService classDetailsService;
	
	
	@RequestMapping(value = "/saveClassDetails", method = RequestMethod.POST)
	public String saveClassDetails(@RequestBody ClassDetailsRequest classDetailsRequest) {
		return classDetailsService.saveClassDetails(classDetailsRequest);
	}
	
	
	@RequestMapping(value = "/getClassDetailsList", method = RequestMethod.GET)
	public List<ClassDetailsResponse> getClassDetailsList() {
		return classDetailsService.getClassDetailsList();
	}
	
	@RequestMapping(value = "/getClassNamesList", method = RequestMethod.GET)
	public List<NameValuePair> getClassNamesList() {
		return classDetailsService.getClassNamesList();
	}

}
