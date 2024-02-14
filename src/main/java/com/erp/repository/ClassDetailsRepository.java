package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.ClassDetails;

@Repository
public interface ClassDetailsRepository extends JpaRepository<ClassDetails, Long>{

}
