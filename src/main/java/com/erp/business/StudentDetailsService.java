package com.erp.business;

import java.util.List;

import com.erp.dto.StudentDetailsRequest;
import com.erp.dto.StudentDetailsResponse;

public interface StudentDetailsService {
	
	public long saveStudentDetails(StudentDetailsRequest studentDetailsRequest);
	public List<StudentDetailsResponse> getStudentList();
	public boolean deleteStudent(Long id);

}
