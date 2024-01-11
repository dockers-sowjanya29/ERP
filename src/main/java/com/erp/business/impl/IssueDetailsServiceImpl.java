package com.erp.business.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.IssueDetailsService;
import com.erp.dto.IssueDetailsRequest;
import com.erp.entity.IssueDetails;
import com.erp.repository.IssueDetailsRepository;

@Service
public class IssueDetailsServiceImpl implements IssueDetailsService{
	
	@Autowired
	IssueDetailsRepository issueDetailsRepository;

	@Override
	public boolean saveIssueDetails(IssueDetailsRequest issueDetailsRequest) {
		
		if(issueDetailsRequest!=null) {
			IssueDetails issueDet=new IssueDetails();
			
			issueDet.setInventoryId(issueDetailsRequest.getInventoryId());
			issueDet.setIssueTo(issueDetailsRequest.getIssueTo());
			issueDet.setIssueDate(Calendar.getInstance());
			issueDet.setQuantity(issueDetailsRequest.getQuantity());
			issueDet=issueDetailsRepository.save(issueDet);
			
			if(issueDet!=null) {
				return true;
			}
			
		}
		return false;
	}

}
