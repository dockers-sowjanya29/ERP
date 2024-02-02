package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.business.impl.SchoolServiceImpl;
import com.erp.dto.NameValuePair;
import com.erp.dto.SchoolRequest;
import com.erp.dto.SchoolResponse;

@RestController
@RequestMapping("controller/erp/school")
public class SchoolController {

	@Autowired
	SchoolServiceImpl schoolServiceImpl;

	@RequestMapping(value = "/saveSchoolDetails", method = RequestMethod.POST)
	public String saveSchoolDetails(@RequestBody SchoolRequest schoolreq) {
		return schoolServiceImpl.saveSchoolDetails(schoolreq);
	}
	
	
	@RequestMapping(value = "/getSchoolDetailsById", method = RequestMethod.GET)
	public SchoolResponse getSchoolDetailsById(@RequestBody Long schoolId) {
		  return schoolServiceImpl.getSchoolDetailsById(schoolId);
	}
	
	
	@RequestMapping(value = "/getSchoolDetailsByName", method = RequestMethod.GET)
	public SchoolResponse getSchoolDetailsByName(@RequestBody String schoolName) {
		  return schoolServiceImpl.getSchoolDetailsByName(schoolName);
	}
	
	@RequestMapping(value = "/loadSchools", method = RequestMethod.GET)
	public List<NameValuePair> loadSchools(){
		return schoolServiceImpl.loadSchools();
	}
	
	@RequestMapping(value = "/updateSchool", method = RequestMethod.POST)
	public SchoolResponse uploadSchool(@RequestBody SchoolRequest schoolreq){
		return schoolServiceImpl.updateSchool(schoolreq);
	}
	

	@RequestMapping(value = "/activateSchool", method = RequestMethod.POST)
	public SchoolResponse activateSchool(@RequestBody Long schoolId){
		return schoolServiceImpl.activateSchool(schoolId);
	}
	
	@RequestMapping(value = "/deactiveSchool", method = RequestMethod.POST)
	public SchoolResponse deactiveSchool(@RequestBody Long schoolId){
		return schoolServiceImpl.deactiveSchool(schoolId);
	}

}
