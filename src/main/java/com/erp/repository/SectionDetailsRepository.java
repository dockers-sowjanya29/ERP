package com.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erp.entity.SectionDetails;

@Repository
public interface SectionDetailsRepository extends JpaRepository<SectionDetails, Long> {

	@Modifying
	@Query("DELETE from  SectionDetails sect where sect.classId=?1")
	public void deleteSectionDetails(Long classId);

	@Query("SELECT sectionName FROM SectionDetails sds where sds.id=?1")
	public String getSectionNameById(Long id);
	
	@Query("FROM SectionDetails sds where sds.classId=?1")
	public List<SectionDetails> getSectionsByClassId(Long classId);

}
