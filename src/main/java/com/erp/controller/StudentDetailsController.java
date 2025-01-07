package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.erp.business.StudentDetailsService;
import com.erp.dto.StudentDetailsRequest;

@RestController
@RequestMapping("controller/erp/studentDetails")
public class StudentDetailsController {
	
	@Autowired
	StudentDetailsService studentDetailsService;
	

	@RequestMapping(value = "/saveStudentDetails", method = RequestMethod.POST)
	public long saveStudentDetails(@RequestBody  StudentDetailsRequest studentDetailsRequest) {
		return studentDetailsService.saveStudentDetails(studentDetailsRequest);
	}

}
