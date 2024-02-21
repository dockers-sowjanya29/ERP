package com.erp.business.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.SectionDetailsService;
import com.erp.dto.SectionDetailsRequest;
import com.erp.entity.ClassDetails;
import com.erp.entity.SectionDetails;
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

}
