package com.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.erp.entity.ReferenceData;

@Repository
public interface ReferenceDataRepository extends JpaRepository<ReferenceData,Long>{
	
	
	public List<ReferenceData> findAllByRefTypeId(Long Id); 

}