package com.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public List<Role> findBySchoolId(Long schoolId);
	
	public List<Role> findByRoleRefId(Long roleRefId);
	
	public List<Role> findBySchoolIdAndRoleRefId(Long schoolId,Long roleRefId);

}
