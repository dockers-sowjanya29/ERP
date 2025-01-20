package com.erp.business.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.FileUploadService;
import com.erp.entity.SchoolProfile;
import com.erp.entity.StaffDetails;
import com.erp.entity.StudentDetails;
import com.erp.repository.SchoolProfileRepository;
import com.erp.repository.StaffDetailsRepository;
import com.erp.repository.StudentDetailsRepository;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	StaffDetailsRepository staffDetailsRepository;
	
	@Autowired
	SchoolProfileRepository schoolProfileRepository;
	
	@Autowired
	StudentDetailsRepository studentDetailsRepository;

	@Override
	public String uploadImage(Long id, String type, byte[] imageContent) {

		if (type.equals("STAFF")) {

			StaffDetails staffDetails = getDetails(staffDetailsRepository.findById(id));
			if (staffDetails != null) {
				staffDetails.setProfilePhoto(imageContent);
				staffDetailsRepository.save(staffDetails);
				return "Image saved successfully";

			}

		}
		else if(type.equals("PROFILE")) {
			SchoolProfile profileDetails = getDetails(schoolProfileRepository.findById(id));
			if (profileDetails != null) {
				profileDetails.setLogo(imageContent);
				schoolProfileRepository.save(profileDetails);
				return "Image saved successfully";

			}	
		}
			
	   else if(type.equals("STUDENT")) {
			StudentDetails studentDetails = getDetails(studentDetailsRepository.findById(id));
			if(studentDetails !=null) {
				studentDetails.setProfilePhoto(imageContent);
				//studentDetailsRepository.save(studentDetails);
				//studentDetailsRepository.flush();
				studentDetailsRepository.saveAndFlush(studentDetails);
				System.out.println("STUDENT--->"+ studentDetails.getId());
				System.out.println("STUDENT--->"+ studentDetails.getProfilePhoto());
				return "Student saved Successfully";
			}
		}
		
		
	   else if(type.equals("DOCIMAGE")) {
			StudentDetails studentDetails = getDetails(studentDetailsRepository.findById(id));
			if(studentDetails !=null) {
				studentDetails.setDocumentPhoto(imageContent);
				studentDetailsRepository.save(studentDetails);
				System.out.println("DOCIMAGE--->"+ studentDetails.getId());
				System.out.println("DOCIMAGE--->"+ studentDetails.getDocumentPhoto());
				System.out.println("DOCIMAGE--->"+ studentDetails.getProfilePhoto());
				return "Document saved Successfully";
			}
		}
		

		return null;
	}

	// for Optional
	private <T> T getDetails(Optional<T> optional) {
		if (optional != null && optional.get() != null) {
			return optional.get();
		}
		return null;
	}

}
