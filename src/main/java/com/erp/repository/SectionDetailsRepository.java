package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erp.entity.SectionDetails;

@Repository
public interface SectionDetailsRepository extends JpaRepository<SectionDetails, Long>{
	
	 @Modifying
	 @Query("DELETE from  SectionDetails sect where sect.classId=?1")
	 public void deleteSectionDetails(Long classId);

}
