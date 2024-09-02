package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.business.IssueDetailsService;
import com.erp.dto.IssueDetailsRequest;


@RestController
@RequestMapping("controller/erp/issueDetails")
public class IssueController {

	
	@Autowired
    IssueDetailsService issueDetailsService;
	

	@RequestMapping(value = "/saveIssueDetails", method = RequestMethod.POST)
	public String saveIssueDetails(@RequestBody IssueDetailsRequest issueDetailsRequest) {
		
		boolean result= issueDetailsService.saveIssueDetails(issueDetailsRequest);
		
	
		if(result)
		{
			return "Issue Details Saved Sucessfully";
		}
		
		else
		{
			return "Issue Details Not Saved Sucessfully";
		}
	}
	
}
