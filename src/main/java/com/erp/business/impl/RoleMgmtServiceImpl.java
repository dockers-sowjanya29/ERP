package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.RoleMgmtService;
import com.erp.dto.RoleRequest;
import com.erp.dto.RoleResponse;
import com.erp.entity.ReferenceDataLang;
import com.erp.entity.Role;
import com.erp.repository.ReferenceDataLangRepository;
import com.erp.repository.ReferenceDataRepository;
import com.erp.repository.RoleRepository;


@Service
public class RoleMgmtServiceImpl implements RoleMgmtService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	ReferenceDataLangRepository referenceDataLangRepository;

	@Override
	public String createRole(RoleRequest request) {
		Role role=null;
		
		if (request != null) {
			role = new Role();
			//role.setId(request.getId());
			   if(request.getFeatures()!=null && request.getFeatures().length>0) {
					role.setFeatures(request.getFeatures()[0]); 
			   }
			role.setSchoolId(request.getSchoolId());
			role.setUserName(request.getUserName());
			role.setPassword(request.getPassword());
			role.setPhoneNumber(request.getPhoneNumber());
			role.setRoleRefId(request.getRoleRefId());
			role= roleRepository.save(role);	
			if(role!=null) {
				return role.getUserName();
			}

		}
		
		return null;
	}

	@Override
	public List<RoleResponse> loadAllRoles(RoleRequest request){
		
		List<RoleResponse> roleResponses=new ArrayList<RoleResponse>();
		List<Role> roles=null;
		if(request!=null) {
			
			if(request.getSchoolId()!=null && request.getRoleRefId()!=null) {
				
				roles=roleRepository.findBySchoolIdAndRoleRefId(request.getSchoolId(), request.getRoleRefId());
			}
			else if(request.getSchoolId()!=null){
				roles=roleRepository.findBySchoolId(request.getSchoolId());
				
			}
			else if(request.getRoleRefId()!=null) {
				roles=roleRepository.findByRoleRefId(request.getRoleRefId());
				}
			else
			{
				roles=roleRepository.findAll();
			}
				
		}
		if(roles!=null && !roles.isEmpty()) {
			for(Role role : roles) {
				RoleResponse roleResponse=new RoleResponse();
				roleResponse.setUserName(role.getUserName());
				ReferenceDataLang label = referenceDataLangRepository.getReferenceById(role.getRoleRefId());
				if(label!=null) {
				roleResponse.setRoleText(label.getRefDataLabel());
				}
				roleResponse.setAssignedDate(role.getAssignedDate());
				roleResponse.setLastLogin(role.getLastLogin());
				roleResponse.setId(role.getId());
				roleResponses.add(roleResponse);
			}
		}
	return roleResponses;
		
	}

	@Override
	public String deleteRole(Long roleId) {
		if(roleId!=null) {
			Optional<Role> roleOptional=roleRepository.findById(roleId);
			if(roleOptional!=null) {
				roleRepository.delete(roleOptional.get());
		           return "Role Deleted Succesfully";
			}
			
		}
		return null;
	}
	
		
}
