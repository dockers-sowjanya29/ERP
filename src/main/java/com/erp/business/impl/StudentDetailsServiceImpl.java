package com.erp.business.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.StudentDetailsService;
import com.erp.dto.StudentDetailsRequest;
import com.erp.entity.StudentDetails;
import com.erp.repository.StudentDetailsRepository;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService{

	@Autowired
	private StudentDetailsRepository studentDetailsRepository;
	
	@Override
	public long saveStudentDetails(StudentDetailsRequest studentDetailsRequest) {
		
		StudentDetails studentDetails=convertStudentRequestToStudentDetailsEntity(studentDetailsRequest);
		studentDetails=studentDetailsRepository.save(studentDetails);
		if(studentDetails!=null) {
			return studentDetails.getId();
		}		
		return 0;
	}

	private StudentDetails convertStudentRequestToStudentDetailsEntity(StudentDetailsRequest studentDetailsRequest) 
	{
		
		System.out.println("enetred method--->");
		StudentDetails studentDetails = new StudentDetails();
		
		BeanUtils.copyProperties(studentDetailsRequest, studentDetails);
		System.out.println(studentDetails.getProfilePhoto());
		studentDetails.setProfilePhoto(studentDetailsRequest.getProfilePhoto());
		System.out.println(studentDetails.getProfilePhoto());
		studentDetails.setClassId(3);
		studentDetails.setSectionId(61);
		return studentDetails;
	}
	
	
	

}
