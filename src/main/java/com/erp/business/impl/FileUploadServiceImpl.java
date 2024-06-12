package com.erp.business.impl;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.FileUploadService;
import com.erp.entity.Inventory;
import com.erp.entity.StaffDetails;
import com.erp.repository.StaffDetailsRepository;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	StaffDetailsRepository staffDetailsRepository;

	@Override
	public String uplaodImage(Long id, String type, byte[] imageContent) {

		if (type.equals("STAFF")) {

			StaffDetails staffDetails = getDetails(staffDetailsRepository.findById(id));
			if (staffDetails != null) {
				staffDetails.setProfilePhoto(imageContent);
				staffDetailsRepository.save(staffDetails);
				return "Image saved successfully";

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
