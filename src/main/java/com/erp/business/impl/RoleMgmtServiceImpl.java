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
		boolean updateRole=false;
		
		if (request != null) {
			if(request.getId()!=null) {
				Optional<Role> roleOptional=roleRepository.findById(request.getId());
				if(roleOptional!=null) {
					role=roleOptional.get();
					updateRole=true;
			        
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

				List<RoleFeature> roleFeaturesToDB=new ArrayList<>();
				
				if(updateRole==false) {
						for(Long featureId: request.getFeatures()) {
							RoleFeature roleFeature=new RoleFeature();
							roleFeature.setRole(role);
							roleFeature.setFeatureRefId(featureId);
						//	roleFeaturesToDB.add(roleFeature);
							role.getRoleFeatures().add(roleFeature);
					     }
						role= roleRepository.save(role); //new object
				   }
				
					else{
						
						List<RoleFeature> roleFeaturesFromDB=role.getRoleFeatures();
						List<RoleFeature> featuresIDToUpdateDB=new ArrayList<>();
						for(RoleFeature roleFeature: role.getRoleFeatures())
						{
							for(Long featureId: request.getFeatures()) {
							 if(featureId!=roleFeature.getFeatureRefId()) {
								 role.getRoleFeatures().remove(roleFeature);
							 }
							}
						}
						role= roleRepository.save(role); //after remove-save
						
						roleFeaturesFromDB=role.getRoleFeatures();
						for(RoleFeature roleFeature: role.getRoleFeatures())
						{
							for(Long featureId: request.getFeatures()) {
							 if(featureId!=roleFeature.getFeatureRefId()) {
								 RoleFeature roleFeatToDB=new RoleFeature();
								 roleFeature.setRole(role);
								 roleFeature.setFeatureRefId(featureId);
								 featuresIDToUpdateDB.add(roleFeatToDB);
							   }
							}
						}
						role.setRoleFeatures(featuresIDToUpdateDB);
						role= roleRepository.save(role); //inserting new features while updating role
					}
			}	
			if(role!=null) {
				//boolean roleFeaturesUpdted=createOrUpdateFeatures(role.getId(), request.getFeatures());
				//if(roleFeaturesUpdted)
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
		if (roleId != null) {
			roleRepository.deleteById(roleId);
			return "Role Deleted Succesfully";
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
				   
				//   List<RoleFeature> roleFeatures=roleFeatureRepository.findAllBySchoolRoleId(roleId);
				   List<NameValuePair> featureNameValuePairs=new ArrayList<>();
				   List<RoleFeature> roleFeatures=role.getRoleFeatures();
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
	// @Transactional
	/*public boolean	createOrUpdateFeatures(Role role,Long uiFeatures[])
	{
		if(role!=null && uiFeatures!=null && uiFeatures.length>0)
		{
			//get all the list from db
			List<RoleFeature> roleFeaturesFromDB=role.getRoleFeatures();
		
			if(roleFeaturesFromDB!=null && roleFeaturesFromDB.size()>0) {
				List<Long> originalList=new ArrayList<>();
				
				for(RoleFeature roleFeature: roleFeaturesFromDB) {
					originalList.add(roleFeature.getFeatureRefId()); //original list from database
					
				}
				//preparing removed list from UI
				List<Long> dataToUpdate=getUnCommonData(originalList,Arrays.asList(uiFeatures)); 
				
				if(dataToUpdate!=null && dataToUpdate.size()>0) {
				     // roleFeatureRepository.deleteBySchoolRoleIdAndFeatureRefIdIn(roleId,dataToUpdate);//removed list
				  }
				//preparing new list from UI
				originalList=new ArrayList<>();
				//roleFeaturesFromDB=roleFeatureRepository.findAllBySchoolRoleId(roleId);
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
	}*/


	
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
		//	roleFeature.setSchoolRoleId(roleId);
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
