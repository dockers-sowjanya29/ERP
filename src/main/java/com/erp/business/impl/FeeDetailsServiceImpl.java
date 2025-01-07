package com.erp.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.erp.business.FeeDetailsService;
import com.erp.dto.FeeDetailsRequest;
import com.erp.repository.FeeDetailsRepository;

public class FeeDetailsServiceImpl {
	
	@Autowired
	FeeDetailsRepository feeDetailsRepository;
	
	@Autowired
	FeeDetailsService feeDetailsService;
	
	//@Override
	public String saveFeeDetails(FeeDetailsRequest feeDetailsRequest)  {
		
		return null;
	}

}
