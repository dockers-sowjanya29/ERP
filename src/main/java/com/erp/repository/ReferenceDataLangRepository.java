package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.entity.ReferenceDataLang;

public interface ReferenceDataLangRepository extends JpaRepository<ReferenceDataLang, Long> {

	
	public ReferenceDataLang findByRefDataIdAndLangType(Long refDataID, String langType); 

}
