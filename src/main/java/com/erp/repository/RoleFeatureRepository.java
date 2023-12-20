package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.RoleFeature;

@Repository
public interface RoleFeatureRepository extends JpaRepository<RoleFeature, Long> {

}
