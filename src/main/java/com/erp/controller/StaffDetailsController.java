package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.erp.business.StaffDetailsService;
import com.erp.dto.StaffDetailsRequest;
import com.erp.dto.StaffDetailsResponse;


@RestController
@RequestMapping("controller/erp/staffDetails")
public class StaffDetailsController {
	
	@Autowired
	StaffDetailsService staffDetailsService;
	

	@RequestMapping(value = "/saveStaffDetails", method = RequestMethod.POST)
	public long saveStaffDetails(@RequestBody StaffDetailsRequest staffDetailsRequest) {
		return staffDetailsService.saveStaffDetails(staffDetailsRequest);
	}

	@RequestMapping(value = "/getStaffList", method = RequestMethod.GET)
	public List<StaffDetailsResponse> getStaffList() {
		return staffDetailsService.getStaffList();
	}
	
	
	@RequestMapping(value = "/deleteStaff", method = RequestMethod.POST)
	public boolean deleteStaff(@RequestBody Long id) {
		return staffDetailsService.deleteStaff(id);
	}

	
	
}
