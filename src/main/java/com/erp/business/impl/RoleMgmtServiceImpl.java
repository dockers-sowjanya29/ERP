package com.erp.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.RoleMgmtService;
import com.erp.dto.NameValuePair;
import com.erp.dto.RoleRequest;
import com.erp.dto.RoleResponse;
import com.erp.entity.ReferenceDataLang;
import com.erp.entity.Role;
import com.erp.entity.RoleFeature;
import com.erp.repository.ReferenceDataLangRepository;
import com.erp.repository.RoleFeatureRepository;
import com.erp.repository.RoleRepository;


@Service
public class RoleMgmtServiceImpl implements RoleMgmtService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	ReferenceDataLangRepository referenceDataLangRepository;
	
	@Autowired
	RoleFeatureRepository roleFeatureRepository;

	@Override
	public String createRole(RoleRequest request) {
		Role role=null;
		
		if (request != null) {
			if(request.getId()!=null) {
				Optional<Role> roleOptional=roleRepository.findById(request.getId());
				if(roleOptional!=null) {
					role=roleOptional.get();
			        
				}	
			}
			else {
			    role = new Role();
			}
			if(role!=null)
			{
				
				   if(request.getFeatures()!=null && request.getFeatures().length>0) {
						role.setFeatures(request.getFeatures()[0]); 
				   }
				role.setSchoolId(request.getSchoolId());
				role.setUserName(request.getUserName());
				role.setPassword(request.getPassword());
				role.setPhoneNumber(request.getPhoneNumber());
				role.setRoleRefId(request.getRoleRefId());
				role.setAssignedDate(Calendar.getInstance());
				role.setLastLogin(Calendar.getInstance());
				role= roleRepository.save(role);
				
			}	
			if(role!=null) {
				boolean roleFeaturesUpdted=createOrUpdateFeatures(role.getId(), request.getFeatures());
				if(roleFeaturesUpdted)
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

	@Override
	public RoleResponse getRoleById(Long roleId) {
		if(roleId!=null) {
			Optional<Role> roleOptional=roleRepository.findById(roleId);
			if(roleOptional!=null) {
				Role role=roleOptional.get();
				if(role!=null)
				{
				   RoleResponse roleResponse=new RoleResponse();
				   roleResponse.setUserName(role.getUserName());
				   roleResponse.setPhoneNumber(role.getPhoneNumber());
				   roleResponse.setPassword(role.getPassword());
				   roleResponse.setId(role.getId());
				   roleResponse.setSchoolId(role.getSchoolId());
				   roleResponse.setFeatures(role.getFeatures());
				   roleResponse.setRoleRefId(role.getRoleRefId());
				   
				   List<RoleFeature> roleFeatures=roleFeatureRepository.findAllBySchoolRoleId(roleId);
				   List<NameValuePair> featureNameValuePairs=new ArrayList<>();
				   
				   for(RoleFeature feature: roleFeatures) {
					   NameValuePair nameValuePair=new NameValuePair();
					   ReferenceDataLang dataLang=referenceDataLangRepository.getReferenceById(feature.getFeatureRefId());
					  if(dataLang!=null) {
					   nameValuePair.setValue(feature.getFeatureRefId().toString());
					   nameValuePair.setName(dataLang.getRefDataLabel());
					   featureNameValuePairs.add(nameValuePair);
					  }
					  
				   }
					roleResponse.setFeaturesList(featureNameValuePairs);
				   return roleResponse;
			  }	
		   }
		}	
		return null;
	}
	

//features method
	
	public boolean	createOrUpdateFeatures(Long roleId,Long features[])
	{
		
		if(roleId!=null && features!=null && features.length>0)
		{
			List<RoleFeature> roleFeatures=new ArrayList<>();
			for(Long featureId: features) {
				RoleFeature roleFeature=new RoleFeature();
				roleFeature.setSchoolRoleId(roleId);
				roleFeature.setFeatureRefId(featureId);
				roleFeatures.add(roleFeature);
			}
			if(roleFeatures.size()>0) {
			roleFeatureRepository.saveAll(roleFeatures);}
		}
		return false;
	}
	
}
