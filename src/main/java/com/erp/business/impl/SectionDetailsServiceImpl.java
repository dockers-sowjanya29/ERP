package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.SectionDetailsService;
import com.erp.dto.NameValuePair;
import com.erp.dto.SectionDetailsRequest;
import com.erp.dto.SectionDetailsResponse;
import com.erp.dto.SubjectDetailsResponse;
import com.erp.entity.ClassDetails;
import com.erp.entity.SectionDetails;
import com.erp.entity.SubjectDetails;
import com.erp.repository.SectionDetailsRepository;

@Service
public class SectionDetailsServiceImpl implements SectionDetailsService {

	@Autowired
	SectionDetailsRepository sectionDetailsRepository;
	
	@Override
	public String saveSectionDetails(SectionDetailsRequest sectionDetailsRequest) {
		SectionDetails sectionDetails=null;
		if (sectionDetailsRequest != null) {
			if (sectionDetailsRequest.getId() != null) {
				sectionDetails = getSectionDetails(sectionDetailsRequest.getId());
			}
			else {
				sectionDetails = new SectionDetails();
			}
			BeanUtils.copyProperties(sectionDetailsRequest, sectionDetails);
			sectionDetails = sectionDetailsRepository.save(sectionDetails);
			if(sectionDetails != null) {
				return "Section Details Saved Successfully";
			}
		}
		return null;
	
	}
	
	
	private SectionDetails getSectionDetails(Long sectionId) {
		Optional<SectionDetails> optSectionOptional = sectionDetailsRepository.findById(sectionId);
		if (optSectionOptional != null && optSectionOptional.get() != null) {
			return optSectionOptional.get();
		}
		return null;
	}


	
	@Override
	public List<NameValuePair> getSectionNamesList() {
		List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>();
		List<SectionDetailsResponse> list = getSectionDetailsList();
		for(SectionDetailsResponse cdr : list ) {
			NameValuePair nameValuePair=new NameValuePair();
			nameValuePair.setName(cdr.getSectionName());
			nameValuePair.setValue(cdr.getId().toString());
			nameValuePairs.add(nameValuePair);
		}
		return nameValuePairs;
	}

   
	@Override
	public List<SectionDetailsResponse> getSectionDetailsList() {
		List<SectionDetailsResponse> list = new ArrayList<>();
		List<SectionDetails> listSectionDetails = sectionDetailsRepository.findAll();
		if (listSectionDetails != null & !listSectionDetails.isEmpty()) {
			for (SectionDetails cd : listSectionDetails) {
				SectionDetailsResponse sectionDetailsResponse=new SectionDetailsResponse();
				BeanUtils.copyProperties(cd, sectionDetailsResponse);
				list.add(sectionDetailsResponse);
			}
		  }
		return list;
	}


}
