package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.SchoolService;
import com.erp.dto.NameValuePair;
import com.erp.dto.SchoolRequest;
import com.erp.dto.SchoolResponse;
import com.erp.entity.School;
import com.erp.repository.SchoolRepository;
import com.erp.util.ErpConstants;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	SchoolRepository schoolRepository;

	@Override
	public String saveSchoolDetails(SchoolRequest schoolreq) {

		School schoolDet = null;

		if (schoolreq != null) {
			schoolDet = new School();
			schoolDet.setId(schoolreq.getId());
			schoolDet.setSchoolName(schoolreq.getSchoolName());
			schoolDet.setContactNo(schoolreq.getContactNo());
			schoolDet.setEmailId(schoolreq.getEmailId());
			schoolDet.setLogo(schoolreq.getLogo().getBytes());
			schoolDet.setLocation(schoolreq.getLocation());
			schoolDet.setWebsite(schoolreq.getWebsite());
			schoolDet.setStatus(ErpConstants.STATUS_ACTIVE);

			schoolDet = schoolRepository.save(schoolDet); //
		}

		if (schoolDet != null) {
			return schoolDet.getSchoolName();
		}

		return null;
	}

	@Override
	public SchoolResponse getSchoolDetailsById(Long schoolId) {
		
		Optional<School> schoolOptional = schoolRepository.findById(schoolId);
		if(schoolOptional!=null && schoolOptional.isPresent())
		{
			School schoolDet = schoolOptional.get();
			if(schoolDet!=null)
			{
				SchoolResponse schoolResponse=new SchoolResponse();
				schoolResponse.setId(schoolDet.getId());
				schoolResponse.setSchoolName(schoolDet.getSchoolName());
				schoolResponse.setEmailId(schoolDet.getEmailId());
				schoolResponse.setLocation(schoolDet.getLocation());
				schoolResponse.setLogo(schoolDet.getLogo());
				schoolResponse.setContactNo(schoolDet.getContactNo());
				schoolResponse.setWebsite(schoolDet.getWebsite());
				schoolResponse.setStatus(ErpConstants.STATUS_ACTIVE);
				return schoolResponse;
			}
			
		}
		return null;
	}

	@Override
	public SchoolResponse getSchoolDetailsByName(String schoolName) {
		
		System.out.println("inside Name method---->>"+schoolName);
		
		List<School> schoolsList=schoolRepository.findBySchoolName(schoolName);
		
		
		System.out.println("schoolsList---->>"+schoolsList);
		if(schoolsList!=null && !schoolsList.isEmpty())
		{
			School schoolDet=schoolsList.get(0);
			System.out.println("schoolsList---->>"+schoolDet);
			if(schoolDet!=null)
			{
				SchoolResponse schoolResponse=new SchoolResponse();
				schoolResponse.setId(schoolDet.getId());
				schoolResponse.setSchoolName(schoolDet.getSchoolName());
				schoolResponse.setEmailId(schoolDet.getEmailId());
				schoolResponse.setLocation(schoolDet.getLocation());
				schoolResponse.setLogo(schoolDet.getLogo());
				schoolResponse.setContactNo(schoolDet.getContactNo());
				schoolResponse.setWebsite(schoolDet.getWebsite());
				schoolResponse.setStatus(schoolDet.getStatus());
				return schoolResponse;
			}
		}
		return null;
	 }
	
		@Override
		public List<NameValuePair> loadSchools(){
		
			List<School> schools=schoolRepository.findAll();
			
			if(schools!=null && !schools.isEmpty())
			{
				List<NameValuePair>  response=new ArrayList<>();
				for(School schoolDet: schools) {
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
		public SchoolResponse updateSchool(SchoolRequest schoolRequest) {
			
			if(schoolRequest!=null) {
				
				School schoolDet=getSchoolById(schoolRequest.getId());
				
				if(schoolDet!=null) {
					schoolDet.setId(schoolRequest.getId());
					schoolDet.setSchoolName(schoolRequest.getSchoolName());
					schoolDet.setContactNo(schoolRequest.getContactNo());
					schoolDet.setEmailId(schoolRequest.getEmailId());
					schoolDet.setLogo(schoolRequest.getLogo().getBytes());
					schoolDet.setLocation(schoolRequest.getLocation());
					schoolDet.setWebsite(schoolRequest.getWebsite());
					schoolDet.setStatus(schoolDet.getStatus());

					schoolDet = schoolRepository.saveAndFlush(schoolDet);
					
					if(schoolDet!=null)
					{
						SchoolResponse schoolResponse=new SchoolResponse();
						schoolResponse.setId(schoolDet.getId());
						schoolResponse.setSchoolName(schoolDet.getSchoolName());
						schoolResponse.setEmailId(schoolDet.getEmailId());
						schoolResponse.setLocation(schoolDet.getLocation());
						schoolResponse.setLogo(schoolDet.getLogo());
						schoolResponse.setContactNo(schoolDet.getContactNo());
						schoolResponse.setWebsite(schoolDet.getWebsite());
						schoolResponse.setStatus(schoolDet.getStatus());
						return schoolResponse;
					}
									
				}
								
			}
			
			
			return null;
		}
		
		
		private School getSchoolById(Long Id) {
			
			Optional<School>  school=schoolRepository.findById(Id);
			if(school!=null && school.isPresent())
			{
				return  school.get();
		     }
	     return null;
	   
		}

		@Override
		public SchoolResponse deactiveSchool(Long schoolId) {
			
			School schoolDet=getSchoolById(schoolId);
			if(schoolDet!=null) {
				schoolDet.setStatus(ErpConstants.STATUS_INACTIVE);
				
				schoolDet = schoolRepository.saveAndFlush(schoolDet);
				
				if(schoolDet!=null)
				{
					SchoolResponse schoolResponse=new SchoolResponse();
					schoolResponse.setId(schoolDet.getId());
					schoolResponse.setSchoolName(schoolDet.getSchoolName());
					schoolResponse.setEmailId(schoolDet.getEmailId());
					schoolResponse.setLocation(schoolDet.getLocation());
					schoolResponse.setLogo(schoolDet.getLogo());
					schoolResponse.setContactNo(schoolDet.getContactNo());
					schoolResponse.setWebsite(schoolDet.getWebsite());
					schoolResponse.setStatus(schoolDet.getStatus());
					return schoolResponse;
				}
				
			}
			return null;
		}

		@Override
		public SchoolResponse activateSchool(Long schoolId) {
			
			School schoolDet=getSchoolById(schoolId);
			if(schoolDet!=null) {
				schoolDet.setStatus(ErpConstants.STATUS_ACTIVE);
				
				schoolDet = schoolRepository.saveAndFlush(schoolDet);
				
				if(schoolDet!=null)
				{
					SchoolResponse schoolResponse=new SchoolResponse();
					schoolResponse.setId(schoolDet.getId());
					schoolResponse.setSchoolName(schoolDet.getSchoolName());
					schoolResponse.setEmailId(schoolDet.getEmailId());
					schoolResponse.setLocation(schoolDet.getLocation());
					schoolResponse.setLogo(schoolDet.getLogo());
					schoolResponse.setContactNo(schoolDet.getContactNo());
					schoolResponse.setWebsite(schoolDet.getWebsite());
					schoolResponse.setStatus(schoolDet.getStatus());
					return schoolResponse;
				}
				
			}
			return null;
		}

}
