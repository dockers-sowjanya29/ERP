package com.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.RoleFeature;

@Repository
public interface RoleFeatureRepository extends JpaRepository<RoleFeature, Long> {
	public List<RoleFeature> findAllBySchoolRoleId(Long schoolRoleId);

}
