package com.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.SchoolProfile;

@Repository
public interface SchoolProfileRepository extends JpaRepository<SchoolProfile, Long> {

	public List<SchoolProfile> findBySchoolName(String schoolName);

}
