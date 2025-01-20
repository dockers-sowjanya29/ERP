package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.erp.business.StudentDetailsService;
import com.erp.dto.StaffDetailsResponse;
import com.erp.dto.StudentDetailsRequest;
import com.erp.dto.StudentDetailsResponse;

@RestController
@RequestMapping("controller/erp/studentDetails")
public class StudentDetailsController {
	
	@Autowired
	StudentDetailsService studentDetailsService;
	

	@RequestMapping(value = "/saveStudentDetails", method = RequestMethod.POST)
	public long saveStudentDetails(@RequestBody  StudentDetailsRequest studentDetailsRequest) {
		return studentDetailsService.saveStudentDetails(studentDetailsRequest);
	}
	
	
	@RequestMapping(value = "/getStudentList", method = RequestMethod.GET)
	public List<StudentDetailsResponse> getStudentList() {
		return studentDetailsService.getStudentList();
	}
	
	
	
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	public boolean deleteStudent(@RequestBody Long id) {
		return studentDetailsService.deleteStudent(id);
	}

}
