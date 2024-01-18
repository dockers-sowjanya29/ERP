package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.business.IssueDetailsService;
import com.erp.business.impl.IssueDetailsServiceImpl;
import com.erp.dto.IssueDetailsRequest;


@RestController
@RequestMapping("controller/erp/issueDetails")
@CrossOrigin(origins = "http://localhost:4200")
public class IssueController {

	
	@Autowired
    IssueDetailsService issueDetailsService;
	

	@RequestMapping(value = "/saveIssueDetails", method = RequestMethod.POST)
	public String saveIssueDetails(@RequestBody IssueDetailsRequest issueDetailsRequest) {
		System.out.println("caLLED saveIssueDetails");
		System.out.println("in saveIssueDetails--->>"+issueDetailsRequest.getIssueTo());
		System.out.println("in saveIssueDetails*****>>"+issueDetailsRequest.getInventoryId());
		System.out.println("in saveIssueDetails*****>>"+issueDetailsRequest.getQuantity());
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
