package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.StaffDetailsService;
import com.erp.dto.StaffDetailsRequest;
import com.erp.dto.StaffDetailsResponse;
import com.erp.entity.Inventory;
import com.erp.entity.StaffDetails;
import com.erp.repository.StaffDetailsRepository;

@Service
public class StaffDetailsServiceImpl implements StaffDetailsService{
	
	@Autowired
	StaffDetailsRepository staffDetailsRepository;

	
	@Override
	public long saveStaffDetails(StaffDetailsRequest staffDetailsRequest) {
		
		StaffDetails staffDetails=convertStaffRequestToStaffDetailsEntity(staffDetailsRequest);
		System.out.println("In save Impl"+staffDetails.getSectionId());
		staffDetails=staffDetailsRepository.save(staffDetails);
		if(staffDetails!=null) {
			return staffDetails.getId();
		}
		return 0;
	}
	
	
	private StaffDetails convertStaffRequestToStaffDetailsEntity(StaffDetailsRequest staffDetailsRequest)
	{
		
		if(staffDetailsRequest!=null) {
			
			System.out.println("In Service Impl"+staffDetailsRequest.getSectionId());
			StaffDetails staffDetails=new StaffDetails();
			staffDetails.setCategoryId(staffDetailsRequest.getCategoryId());
			staffDetails.setDob(staffDetailsRequest.getDob());
			staffDetails.setDoj(staffDetailsRequest.getDoj());
			staffDetails.setEmailId(staffDetailsRequest.getEmailId());
			staffDetails.setExperience(staffDetailsRequest.getExperience());
			staffDetails.setPhoneNo(staffDetailsRequest.getPhoneNo());
			staffDetails.setProfilePhoto(staffDetailsRequest.getProfilePhoto());
			staffDetails.setQualification(staffDetailsRequest.getQualification());
			staffDetails.setSalary(staffDetailsRequest.getSalary());
			staffDetails.setStaffLocation(staffDetailsRequest.getStaffLocation());
			staffDetails.setStaffName(staffDetailsRequest.getStaffName());
			staffDetails.setSubjectId(staffDetailsRequest.getSubjectId());
			staffDetails.setClassId(staffDetailsRequest.getClassId());
			staffDetails.setSectionId(staffDetailsRequest.getSectionId());
			return staffDetails;
		}
		
		return null;
	}


	@Override
	public List<StaffDetailsResponse> getStaffList() {
		List<StaffDetailsResponse> staffDetailsResponses =new ArrayList<StaffDetailsResponse>();
		List<StaffDetails> staffDetailsList=staffDetailsRepository.findAll();
		if(staffDetailsList!=null && !staffDetailsList.isEmpty()) {
			for(StaffDetails staffDetails:staffDetailsList)
			{
				if(staffDetails!=null) {
					
					StaffDetailsResponse staffDetailsResponse=new StaffDetailsResponse();
					staffDetailsResponse.setId(staffDetails.getId());
					staffDetailsResponse.setStaffName(staffDetails.getStaffName());
					staffDetailsResponse.setPhoneNo(staffDetails.getPhoneNo());
					staffDetailsResponse.setCategoryId(staffDetails.getCategoryId());
					staffDetailsResponses.add(staffDetailsResponse);
				}
			}
		}
		
		return staffDetailsResponses;
	}


	@Override
	public boolean deleteStaff(Long id) {
		if(id!=null)
		{
			staffDetailsRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
