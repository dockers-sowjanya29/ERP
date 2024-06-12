package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.SchoolProfileService;
import com.erp.dto.NameValuePair;
import com.erp.dto.SchoolProfileRequest;
import com.erp.dto.SchoolProfileResponse;
import com.erp.entity.SchoolProfile;
import com.erp.repository.SchoolProfileRepository;
import com.erp.util.ErpConstants;

@Service
public class SchoolProfileServiceImpl implements SchoolProfileService {

	@Autowired
	SchoolProfileRepository schoolProfileRepository;

	@Override
	public String saveSchoolDetails(SchoolProfileRequest schoolreq) {

		SchoolProfile schoolDet = null;

		if (schoolreq != null) {
			schoolDet = new SchoolProfile();
			schoolDet.setId(schoolreq.getId());
			schoolDet.setSchoolName(schoolreq.getSchoolName());
			schoolDet.setContactNo(schoolreq.getContactNo());
			schoolDet.setEmailId(schoolreq.getEmailId());
			schoolDet.setLogo(schoolreq.getLogo().getBytes());
			schoolDet.setLocation(schoolreq.getLocation());
			schoolDet.setWebsite(schoolreq.getWebsite());
			schoolDet.setStatus(ErpConstants.STATUS_ACTIVE);

			schoolDet = schoolProfileRepository.save(schoolDet); //
		}

		if (schoolDet != null) {
			return schoolDet.getSchoolName();
		}

		return null;
	}

	@Override
	public SchoolProfileResponse getSchoolDetailsById(Long schoolId) {
		
		Optional<SchoolProfile> schoolOptional = schoolProfileRepository.findById(schoolId);
		if(schoolOptional!=null && schoolOptional.isPresent())
		{
			SchoolProfile schoolDet = schoolOptional.get();
			if(schoolDet!=null)
			{
				SchoolProfileResponse schoolProfileResponse=new SchoolProfileResponse();
				schoolProfileResponse.setId(schoolDet.getId());
				schoolProfileResponse.setSchoolName(schoolDet.getSchoolName());
				schoolProfileResponse.setEmailId(schoolDet.getEmailId());
				schoolProfileResponse.setLocation(schoolDet.getLocation());
				schoolProfileResponse.setLogo(schoolDet.getLogo());
				schoolProfileResponse.setContactNo(schoolDet.getContactNo());
				schoolProfileResponse.setWebsite(schoolDet.getWebsite());
				schoolProfileResponse.setStatus(ErpConstants.STATUS_ACTIVE);
				return schoolProfileResponse;
			}
			
		}
		return null;
	}

	@Override
	public SchoolProfileResponse getSchoolDetailsByName(String schoolName) {
		
		System.out.println("inside Name method---->>"+schoolName);
		
		List<SchoolProfile> schoolsList=schoolProfileRepository.findBySchoolName(schoolName);
		
		
		System.out.println("schoolsList---->>"+schoolsList);
		if(schoolsList!=null && !schoolsList.isEmpty())
		{
			SchoolProfile schoolDet=schoolsList.get(0);
			System.out.println("schoolsList---->>"+schoolDet);
			if(schoolDet!=null)
			{
				SchoolProfileResponse schoolProfileResponse=new SchoolProfileResponse();
				schoolProfileResponse.setId(schoolDet.getId());
				schoolProfileResponse.setSchoolName(schoolDet.getSchoolName());
				schoolProfileResponse.setEmailId(schoolDet.getEmailId());
				schoolProfileResponse.setLocation(schoolDet.getLocation());
				schoolProfileResponse.setLogo(schoolDet.getLogo());
				schoolProfileResponse.setContactNo(schoolDet.getContactNo());
				schoolProfileResponse.setWebsite(schoolDet.getWebsite());
				schoolProfileResponse.setStatus(schoolDet.getStatus());
				return schoolProfileResponse;
			}
		}
		return null;
	 }
	
		@Override
		public List<NameValuePair> loadSchools(){
		
			List<SchoolProfile> schoolProfiles=schoolProfileRepository.findAll();
			
			if(schoolProfiles!=null && !schoolProfiles.isEmpty())
			{
				List<NameValuePair>  response=new ArrayList<>();
				for(SchoolProfile schoolDet: schoolProfiles) {
					NameValuePair schoolResponse=new NameValuePair();
					schoolResponse.setName(schoolDet.getSchoolName());
					schoolResponse.setValue(schoolDet.getId().toString());
					response.add(schoolResponse);
				}
				return response;
			}
			return null;
			
		}

		@Override
		public SchoolProfileResponse updateSchool(SchoolProfileRequest schoolProfileRequest) {
			
			if(schoolProfileRequest!=null) {
				
				SchoolProfile schoolDet=getSchoolById(schoolProfileRequest.getId());
				
				if(schoolDet!=null) {
					schoolDet.setId(schoolProfileRequest.getId());
					schoolDet.setSchoolName(schoolProfileRequest.getSchoolName());
					schoolDet.setContactNo(schoolProfileRequest.getContactNo());
					schoolDet.setEmailId(schoolProfileRequest.getEmailId());
					schoolDet.setLogo(schoolProfileRequest.getLogo().getBytes());
					schoolDet.setLocation(schoolProfileRequest.getLocation());
					schoolDet.setWebsite(schoolProfileRequest.getWebsite());
					schoolDet.setStatus(schoolDet.getStatus());

					schoolDet = schoolProfileRepository.saveAndFlush(schoolDet);
					
					if(schoolDet!=null)
					{
						SchoolProfileResponse schoolProfileResponse=new SchoolProfileResponse();
						schoolProfileResponse.setId(schoolDet.getId());
						schoolProfileResponse.setSchoolName(schoolDet.getSchoolName());
						schoolProfileResponse.setEmailId(schoolDet.getEmailId());
						schoolProfileResponse.setLocation(schoolDet.getLocation());
						schoolProfileResponse.setLogo(schoolDet.getLogo());
						schoolProfileResponse.setContactNo(schoolDet.getContactNo());
						schoolProfileResponse.setWebsite(schoolDet.getWebsite());
						schoolProfileResponse.setStatus(schoolDet.getStatus());
						return schoolProfileResponse;
					}
									
				}
								
			}
			
			
			return null;
		}
		
		
		private SchoolProfile getSchoolById(Long Id) {
			
			Optional<SchoolProfile>  schoolProfile=schoolProfileRepository.findById(Id);
			if(schoolProfile!=null && schoolProfile.isPresent())
			{
				return  schoolProfile.get();
		     }
	     return null;
	   
		}

		@Override
		public SchoolProfileResponse deactiveSchool(Long schoolId) {
			
			SchoolProfile schoolDet=getSchoolById(schoolId);
			if(schoolDet!=null) {
				schoolDet.setStatus(ErpConstants.STATUS_INACTIVE);
				
				schoolDet = schoolProfileRepository.saveAndFlush(schoolDet);
				
				if(schoolDet!=null)
				{
					SchoolProfileResponse schoolProfileResponse=new SchoolProfileResponse();
					schoolProfileResponse.setId(schoolDet.getId());
					schoolProfileResponse.setSchoolName(schoolDet.getSchoolName());
					schoolProfileResponse.setEmailId(schoolDet.getEmailId());
					schoolProfileResponse.setLocation(schoolDet.getLocation());
					schoolProfileResponse.setLogo(schoolDet.getLogo());
					schoolProfileResponse.setContactNo(schoolDet.getContactNo());
					schoolProfileResponse.setWebsite(schoolDet.getWebsite());
					schoolProfileResponse.setStatus(schoolDet.getStatus());
					return schoolProfileResponse;
				}
				
			}
			return null;
		}

		@Override
		public SchoolProfileResponse activateSchool(Long schoolId) {
			
			SchoolProfile schoolDet=getSchoolById(schoolId);
			if(schoolDet!=null) {
				schoolDet.setStatus(ErpConstants.STATUS_ACTIVE);
				
				schoolDet = schoolProfileRepository.saveAndFlush(schoolDet);
				
				if(schoolDet!=null)
				{
					SchoolProfileResponse schoolProfileResponse=new SchoolProfileResponse();
					schoolProfileResponse.setId(schoolDet.getId());
					schoolProfileResponse.setSchoolName(schoolDet.getSchoolName());
					schoolProfileResponse.setEmailId(schoolDet.getEmailId());
					schoolProfileResponse.setLocation(schoolDet.getLocation());
					schoolProfileResponse.setLogo(schoolDet.getLogo());
					schoolProfileResponse.setContactNo(schoolDet.getContactNo());
					schoolProfileResponse.setWebsite(schoolDet.getWebsite());
					schoolProfileResponse.setStatus(schoolDet.getStatus());
					return schoolProfileResponse;
				}
				
			}
			return null;
		}

}
