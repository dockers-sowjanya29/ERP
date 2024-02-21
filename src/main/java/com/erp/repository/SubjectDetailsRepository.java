package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.SubjectDetails;

@Repository
public interface SubjectDetailsRepository extends JpaRepository<SubjectDetails, Long>{

}
