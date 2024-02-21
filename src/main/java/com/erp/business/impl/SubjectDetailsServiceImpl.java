package com.erp.business.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.SubjectDetailsService;
import com.erp.dto.SubjectDetailsRequest;
import com.erp.entity.SubjectDetails;
import com.erp.repository.SubjectDetailsRepository;

@Service
public class SubjectDetailsServiceImpl  implements SubjectDetailsService {
	
	@Autowired
	SubjectDetailsRepository subjectDetailsRepository;

	@Override
	public String saveSubjectDetails(SubjectDetailsRequest subjectDetailsRequest) {
		SubjectDetails subjectDetails=null;
		if (subjectDetailsRequest != null) {
			if (subjectDetailsRequest.getId() != null) {
				subjectDetails = getSubjectDetails(subjectDetailsRequest.getId());
			}
			else {
				subjectDetails = new SubjectDetails();
			}
			BeanUtils.copyProperties(subjectDetailsRequest, subjectDetails);
			subjectDetails = subjectDetailsRepository.save(subjectDetails);
			if(subjectDetails != null) {
				return "Subject Details Saved Successfully";
			}
		}
		return null;
	
	}
	
	private SubjectDetails getSubjectDetails(Long sectionId) {
		Optional<SubjectDetails> optSectionOptional = subjectDetailsRepository.findById(sectionId);
		if (optSectionOptional != null && optSectionOptional.get() != null) {
			return optSectionOptional.get();
		}
		return null;
	}

}
