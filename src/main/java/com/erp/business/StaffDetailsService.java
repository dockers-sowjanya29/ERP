package com.erp.business;

import java.util.List;

import com.erp.dto.StaffDetailsRequest;
import com.erp.dto.StaffDetailsResponse;

public interface StaffDetailsService {
	
	public long saveStaffDetails(StaffDetailsRequest staffDetailsRequest);
	public List<StaffDetailsResponse> getStaffList();
	public boolean deleteStaff(Long id);
}
