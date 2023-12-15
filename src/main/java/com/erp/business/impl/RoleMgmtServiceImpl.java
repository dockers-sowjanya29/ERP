package com.erp.business.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	 @Transactional
	public String createRole(RoleRequest request) { //save//update
		Role role=null;
		
		if (request != null) {
			if(request.getId()!=null) {
				Optional<Role> roleOptional=roleRepository.findById(request.getId());
				if(roleOptional!=null) {
					role=roleOptional.get();
			        
				}	
			}
			else { //new record
			    role = new Role();
			}
			if(role!=null)
			{
			
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
	 @Transactional
	public boolean	createOrUpdateFeatures(Long roleId,Long uiFeatures[])
	{
		if(roleId!=null && uiFeatures!=null && uiFeatures.length>0)
		{
			List<RoleFeature> roleFeaturesFromDB=roleFeatureRepository.findAllBySchoolRoleId(roleId);//get all the list from db

			if(roleFeaturesFromDB!=null && roleFeaturesFromDB.size()>0) {
				List<Long> originalList=new ArrayList<>();
				
				for(RoleFeature roleFeature: roleFeaturesFromDB) {
					originalList.add(roleFeature.getFeatureRefId()); //original list from database
					
				}
				List<Long> dataToUpdate=getUnCommonData(originalList,Arrays.asList(uiFeatures)); //preparing removed list from UI
				
				if(dataToUpdate!=null && dataToUpdate.size()>0) {
				      roleFeatureRepository.deleteBySchoolRoleIdAndFeatureRefIdIn(roleId,dataToUpdate);//removed list
				  }
				//preparing new list from UI
				originalList=new ArrayList<>();
				roleFeaturesFromDB=roleFeatureRepository.findAllBySchoolRoleId(roleId);
				for(RoleFeature roleFeature: roleFeaturesFromDB) { 
					
					originalList.add(roleFeature.getFeatureRefId()); 
				}
				
		     dataToUpdate=getUnCommonData(Arrays.asList(uiFeatures),originalList);
		     if(dataToUpdate!=null && dataToUpdate.size()>0) 
		       {
		    	        Long[] insertFeatures = new Long[dataToUpdate.size()];
		    	        insertFeatures = dataToUpdate.toArray(insertFeatures);
		     	       return saveRoleFeatures(roleId,insertFeatures);
		       }			}
			else {
				
				return saveRoleFeatures(roleId,uiFeatures);
			}
		}
		return false;
	}


	
	private List<Long> getUnCommonData(List<Long> originalList,List<Long> subList)
	{
		List<Long> tempList=new ArrayList<>(originalList);
		if(originalList!=null && subList!=null && originalList.size()>0 && subList.size()>0)
		{
			tempList.removeAll(subList); //list contains items only in name
		}
		return tempList;
	}
	
	
	private boolean saveRoleFeatures(Long roleId, Long[] features)
	{
		List<RoleFeature> roleFeatures=new ArrayList<>();
		
		for(Long featureId: features) {
			RoleFeature roleFeature=new RoleFeature();
			roleFeature.setSchoolRoleId(roleId);
			roleFeature.setFeatureRefId(featureId);
			roleFeatures.add(roleFeature);
		}
		
		if(roleFeatures.size()>0) {
			roleFeatureRepository.saveAll(roleFeatures);
		     return true;	
		}
		
		return false;
	}
	
	
}
