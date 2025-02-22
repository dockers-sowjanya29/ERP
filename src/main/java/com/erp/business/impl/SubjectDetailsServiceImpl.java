package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.SubjectDetailsService;
import com.erp.dto.NameValuePair;
import com.erp.dto.SubjectDetailsRequest;
import com.erp.dto.SubjectDetailsResponse;
import com.erp.entity.SubjectDetails;
import com.erp.repository.SubjectDetailsRepository;

@Service
public class SubjectDetailsServiceImpl implements SubjectDetailsService {

	@Autowired
	SubjectDetailsRepository subjectDetailsRepository;

	@Override
	public String saveSubjectDetails(SubjectDetailsRequest subjectDetailsRequest) {
		SubjectDetails subjectDetails = null;
		if (subjectDetailsRequest != null) {
			if (subjectDetailsRequest.getId() != null) {
				subjectDetails = getSubjectDetails(subjectDetailsRequest.getId());
			} else {
				subjectDetails = new SubjectDetails();
			}
			BeanUtils.copyProperties(subjectDetailsRequest, subjectDetails);
			subjectDetails = subjectDetailsRepository.save(subjectDetails);
			if (subjectDetails != null) {
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

	@Override
	public List<NameValuePair> getSubjectNamesList() {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		List<SubjectDetailsResponse> list = getSubjectDetailsList();
		for (SubjectDetailsResponse cdr : list) {
			NameValuePair nameValuePair = new NameValuePair();
			nameValuePair.setName(cdr.getSubjectName());
			nameValuePair.setValue(cdr.getId().toString());
			nameValuePairs.add(nameValuePair);
		}
		return nameValuePairs;
	}

	@Override
	public List<SubjectDetailsResponse> getSubjectDetailsList() {
		List<SubjectDetailsResponse> list = new ArrayList<>();
		List<SubjectDetails> listSubjectDetails = subjectDetailsRepository.findAll();
		if (listSubjectDetails != null & !listSubjectDetails.isEmpty()) {
			for (SubjectDetails cd : listSubjectDetails) {
				SubjectDetailsResponse subjectDetailsResponse = new SubjectDetailsResponse();
				BeanUtils.copyProperties(cd, subjectDetailsResponse);
				list.add(subjectDetailsResponse);
			}
		}
		return list;
	}

}
