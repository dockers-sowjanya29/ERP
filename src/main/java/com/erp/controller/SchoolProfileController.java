package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.business.impl.SchoolProfileServiceImpl;
import com.erp.dto.NameValuePair;
import com.erp.dto.SchoolProfileRequest;
import com.erp.dto.SchoolProfileResponse;

@RestController
@RequestMapping("controller/erp/schoolProfile")
public class SchoolProfileController {

	@Autowired
	SchoolProfileServiceImpl schoolProfileServiceImpl;

	@RequestMapping(value = "/saveSchoolProfileDetails", method = RequestMethod.POST)
	public Long saveSchoolDetails(@RequestBody SchoolProfileRequest schoolreq) {
		return schoolProfileServiceImpl.saveSchoolDetails(schoolreq);
	}
	
	
	@RequestMapping(value = "/getSchoolProfileDetailsById", method = RequestMethod.GET)
	public SchoolProfileResponse getSchoolDetailsById(@RequestBody Long schoolId) {
		  return schoolProfileServiceImpl.getSchoolDetailsById(schoolId);
	}
	
	
	@RequestMapping(value = "/getSchoolProfileDetailsByName", method = RequestMethod.GET)
	public SchoolProfileResponse getSchoolDetailsByName(@RequestBody String schoolName) {
		  return schoolProfileServiceImpl.getSchoolDetailsByName(schoolName);
	}
	
	@RequestMapping(value = "/loadSchoolProfiles", method = RequestMethod.GET)
	public List<NameValuePair> loadSchools(){
		return schoolProfileServiceImpl.loadSchools();
	}
	
	@RequestMapping(value = "/updateSchoolProfile", method = RequestMethod.POST)
	public SchoolProfileResponse uploadSchool(@RequestBody SchoolProfileRequest schoolreq){
		return schoolProfileServiceImpl.updateSchool(schoolreq);
	}
	

	@RequestMapping(value = "/activateSchoolProfile", method = RequestMethod.POST)
	public SchoolProfileResponse activateSchool(@RequestBody Long schoolId){
		return schoolProfileServiceImpl.activateSchool(schoolId);
	}
	
	@RequestMapping(value = "/deactiveSchoolProfile", method = RequestMethod.POST)
	public SchoolProfileResponse deactiveSchool(@RequestBody Long schoolId){
		return schoolProfileServiceImpl.deactiveSchool(schoolId);
	}

}
