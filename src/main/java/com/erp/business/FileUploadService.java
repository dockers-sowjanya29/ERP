package com.erp.business;



public interface FileUploadService {

	public String uploadImage(Long id,String type,byte[] imageContent);
}
