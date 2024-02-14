package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.ClassDetailsService;
import com.erp.dto.ClassDetailsRequest;
import com.erp.dto.ClassDetailsResponse;
import com.erp.dto.NameValuePair;
import com.erp.entity.ClassDetails;
import com.erp.repository.ClassDetailsRepository;

@Service
public class ClassDetailSServiceImpl implements ClassDetailsService{
	
	@Autowired
	ClassDetailsRepository classDetailsRepository;
	
	@Override
	public String saveClassDetails(ClassDetailsRequest classDetailsRequest) {
		
		ClassDetails classDetails=null;
		if (classDetailsRequest != null) {
			if (classDetailsRequest.getId() != null) {
				classDetails = getClassDetails(classDetailsRequest.getId());
			}
			else {
				classDetails = new ClassDetails();
			}
			BeanUtils.copyProperties(classDetailsRequest, classDetails);
			classDetails = classDetailsRepository.save(classDetails);
			if(classDetails != null) {
				return "Class Details Saved Successfully";
			}
		}
		return null;
	}
	
	
	private ClassDetails getClassDetails(Long classId) {
		Optional<ClassDetails> optClassDetails = classDetailsRepository.findById(classId);
		if (optClassDetails != null && optClassDetails.get() != null) {
			return optClassDetails.get();
		}
		return null;
	}


	@Override
	public List<ClassDetailsResponse> getClassDetailsList() {
		List<ClassDetailsResponse> list = new ArrayList<>();
		List<ClassDetails> listClassDetails = classDetailsRepository.findAll();
		if (listClassDetails != null & !listClassDetails.isEmpty()) {
			for (ClassDetails cd : listClassDetails) {
				ClassDetailsResponse classDetailsResponse=new ClassDetailsResponse();
				BeanUtils.copyProperties(cd, classDetailsResponse);
				list.add(classDetailsResponse);
			}
		  }
		return list;
	}


	@Override
	public List<NameValuePair> getClassNamesList() {
		List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>();
		List<ClassDetailsResponse> list = getClassDetailsList();
		for(ClassDetailsResponse cdr : list ) {
			NameValuePair nameValuePair=new NameValuePair();
			nameValuePair.setName(cdr.getClassName());
			nameValuePair.setValue(cdr.getId().toString());
			nameValuePairs.add(nameValuePair);
		}
		return nameValuePairs;
	}
	
}


