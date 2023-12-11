package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.ReferenceType;


@Repository
public interface ReferenceTypeRepository extends JpaRepository<ReferenceType,Long>{
	

	public ReferenceType findByRefTypeCode(String refTypeCode); 


}