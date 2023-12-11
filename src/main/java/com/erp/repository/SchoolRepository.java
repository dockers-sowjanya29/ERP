package com.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

	public List<School> findBySchoolName(String schoolName);

}
