package com.erp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.erp.business.FileUploadService;

@RestController
@RequestMapping("controller/erp/fileUpload")
public class FileUploadController {
	
	@Autowired
	FileUploadService fileUploadService;
	
	
	
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public String uploadImage(@RequestParam("itemImage") MultipartFile itemImage) throws IOException {
		try {
			String imgData=itemImage.getOriginalFilename();
			String[] imgDataParts=imgData.split(":");
			if(imgDataParts.length>1) {
				//System.out.println("in upload Image"+imgDataParts[0]);
				//System.out.println("in upload Image"+imgDataParts[1]);
				Long id = Long.parseLong(imgDataParts[0]);
				String type = imgDataParts[1];
			
				return fileUploadService.uplaodImage(id, type, itemImage.getBytes());
			}
			else {
				
				return "Image not uploaded";
				
			}
				
		   }catch(NumberFormatException nfe) {
			System.out.println(nfe);
		}
		
		return "Error while saving data";
	}

}
