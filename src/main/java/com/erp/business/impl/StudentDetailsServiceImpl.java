package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.StudentDetailsService;
import com.erp.dto.StaffDetailsResponse;
import com.erp.dto.StudentDetailsRequest;
import com.erp.dto.StudentDetailsResponse;
import com.erp.entity.FeeDetails;
import com.erp.entity.StaffDetails;
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
		
		StudentDetails studentDetails = new StudentDetails();
		BeanUtils.copyProperties(studentDetailsRequest, studentDetails);
		FeeDetails feeDetails = new FeeDetails();
		feeDetails.setAmountPaid(studentDetailsRequest.getAmountPaid());
		feeDetails.setPaidDate(studentDetailsRequest.getPaidDate());
		feeDetails.setTotalAmount(studentDetailsRequest.getTotalAmount());
		feeDetails.setNextDueDate(studentDetailsRequest.getNextDueDate());
		List <FeeDetails> feeDetailsList = new ArrayList<>();
		feeDetailsList.add(feeDetails);
		feeDetails.setStudentDetails(studentDetails);
		studentDetails.setFeeDetails(feeDetailsList);
		return studentDetails;
		
	}

	@Override
	public List<StudentDetailsResponse> getStudentList() {
		
		//System.out.println("getStudentList---->>");
		List<StudentDetailsResponse> studentDetailsResponseList =new ArrayList<StudentDetailsResponse>();
		List<StudentDetails> studentList=studentDetailsRepository.findAll();
      
		if(studentList!=null && !studentList.isEmpty()) {
			for(StudentDetails studentDetails : studentList)
			{
				if(studentDetails!=null) {
					
					StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();
					studentDetailsResponse.setId(studentDetails.getId());
					studentDetailsResponse.setStudentName(studentDetails.getStudentName());
					//System.out.println("student Name"+studentDetails.getStudentName());
					studentDetailsResponse.setClassId(studentDetails.getClassId());
					//System.out.println("student ID"+studentDetails.getId());
					studentDetailsResponse.setSectionId(studentDetails.getClassId());
					studentDetailsResponse.setContactNo(studentDetails.getContactNo());
					//System.out.println("contact no"+studentDetails.getContactNo());
					studentDetailsResponseList.add(studentDetailsResponse);
				}
			}
		}
		return studentDetailsResponseList;
	}

	
	@Override
	public boolean deleteStudent(Long id) {
		if(id!=null) {
			studentDetailsRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	
	

}
