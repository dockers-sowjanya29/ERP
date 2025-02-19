package com.erp.business.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.DocumentDetails;

@Repository
public interface DocumentDetailsRepository extends JpaRepository<DocumentDetails, Long> {

}
