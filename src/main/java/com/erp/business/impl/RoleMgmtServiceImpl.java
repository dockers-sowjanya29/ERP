package com.erp.business.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class RoleMgmtServiceImpl implements RoleMgmtService {
	
	 final static Logger logger = LoggerFactory.getLogger(RoleMgmtServiceImpl.class);

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ReferenceDataLangRepository referenceDataLangRepository;

	@Autowired
	RoleFeatureRepository roleFeatureRepository;

	@Override
	@Transactional
	public String createRole(RoleRequest request) { // save//update
		
	logger.info("inside createRole method.");
		Role role = null;
		boolean updateRole = false;

		if (request != null) {
			if (request.getId() != null) {
				role = getRole(request.getId());
				if (role != null) {
					updateRole = true;

				}
			} else { // new record
				role = new Role();
			}
			if (role != null) {

				role.setSchoolId(request.getSchoolId());
				role.setUserName(request.getUserName());
				role.setPassword(request.getPassword());
				role.setPhoneNumber(request.getPhoneNumber());
				role.setRoleRefId(request.getRoleRefId());
				role.setAssignedDate(Calendar.getInstance());
				role.setLastLogin(Calendar.getInstance());

				if (updateRole == false) {
					for (Long featureId : request.getFeatures()) {
						RoleFeature roleFeature = new RoleFeature();
						roleFeature.setRole(role);
						roleFeature.setFeatureRefId(featureId);
						role.getRoleFeatures().add(roleFeature);
					}
					role = roleRepository.save(role); // new object
				}
				else {
					List<Long> featureIdsFromUi = Arrays.asList(request.getFeatures());
					boolean roleFeaturesUpdated = updateRoleFeatures(role, featureIdsFromUi);
					if(roleFeaturesUpdated) {
						System.out.println("Role Features are Updated/Deleted/Inserted");
					}else {
						System.out.println("Role Features are not Updated/Deleted/Inserted");
					}
				}
			}
			if (role != null) {
				return role.getUserName();
			}

		}

		return null;
	}

	@Override
	public List<RoleResponse> loadAllRoles(RoleRequest request) {

		List<RoleResponse> roleResponses = new ArrayList<RoleResponse>();
		List<Role> roles = null;
		if (request != null) {

			if (request.getSchoolId() != null && request.getRoleRefId() != null) {

				roles = roleRepository.findBySchoolIdAndRoleRefId(request.getSchoolId(), request.getRoleRefId());
			} else if (request.getSchoolId() != null) {
				roles = roleRepository.findBySchoolId(request.getSchoolId());

			} else if (request.getRoleRefId() != null) {
				roles = roleRepository.findByRoleRefId(request.getRoleRefId());
			} else {
				roles = roleRepository.findAll();
			}

		}
		if (roles != null && !roles.isEmpty()) {
			for (Role role : roles) {
				RoleResponse roleResponse = new RoleResponse();
				roleResponse.setUserName(role.getUserName());
				ReferenceDataLang label = referenceDataLangRepository.getReferenceById(role.getRoleRefId());
				if (label != null) {
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
		Role role = getRole(roleId);
		if (role != null) {
			RoleResponse roleResponse = new RoleResponse();
			roleResponse.setUserName(role.getUserName());
			roleResponse.setPhoneNumber(role.getPhoneNumber());
			roleResponse.setPassword(role.getPassword());
			roleResponse.setId(role.getId());
			roleResponse.setSchoolId(role.getSchoolId());
			roleResponse.setRoleRefId(role.getRoleRefId());

			List<NameValuePair> featureNameValuePairs = new ArrayList<>();
			List<RoleFeature> roleFeatures = role.getRoleFeatures();
			for (RoleFeature feature : roleFeatures) {
				NameValuePair nameValuePair = new NameValuePair();
				ReferenceDataLang dataLang = referenceDataLangRepository.getReferenceById(feature.getFeatureRefId());
				if (dataLang != null) {
					nameValuePair.setValue(feature.getFeatureRefId().toString());
					nameValuePair.setName(dataLang.getRefDataLabel());
					featureNameValuePairs.add(nameValuePair);
				}

			}
			roleResponse.setFeaturesList(featureNameValuePairs);
			return roleResponse;
		}
		return null;
	}
	
	private Role getRole(Long roleId) {
		if (roleId != null) {
			Optional<Role> roleOptional = roleRepository.findById(roleId);
			if (roleOptional != null) {
				return roleOptional.get();
			}
		}
		return null;
	}
	
	private boolean updateRoleFeatures(Role role, List<Long> featureIdsFromUi) {
		
		if (role != null && featureIdsFromUi != null)
		{
			//System.out.println("Feature ref ids from Ui");
			//featureIdsFromUi.forEach(roleFeature -> System.out.println(roleFeature));
			List<RoleFeature> roleFeaturesFromDB = new ArrayList<>(role.getRoleFeatures());
			//System.out.println("From DB");
			//roleFeaturesFromDB.forEach(roleFeature -> System.out.println(roleFeature.getFeatureRefId()));
			
			//
			List<RoleFeature> removeFeatures = roleFeaturesFromDB.stream()
					.filter(roleFeatureFromDB -> featureIdsFromUi.stream()
							.allMatch(featureIdFromUi -> roleFeatureFromDB.getFeatureRefId() != featureIdFromUi))
					.collect(Collectors.toList());
			System.out.println("To Remove");
			
			removeFeatures.forEach(roleFeature -> System.out.println(roleFeature.getFeatureRefId()));
			role.getRoleFeatures().removeAll(removeFeatures);
			role = roleRepository.save(role); // after remove-save
			List<RoleFeature> updatedsRoleFeaturesFromDB = new ArrayList<>(role.getRoleFeatures());
			System.out.println("From DB after remove");
			updatedsRoleFeaturesFromDB.forEach(roleFeature -> System.out.println(roleFeature.getFeatureRefId()));
			List<Long> insertFeatures = featureIdsFromUi.stream()
					.filter(featureIdFromUi -> updatedsRoleFeaturesFromDB.stream()
							.allMatch(roleFeatureFromDB -> roleFeatureFromDB.getFeatureRefId() != featureIdFromUi))
					.collect(Collectors.toList());
			System.out.println("Feature ref ids to insert");
			insertFeatures.forEach(roleFeature -> System.out.println(roleFeature));
			List<RoleFeature> roleFeaturesToInsert = new ArrayList<>();
			for (Long featureId : insertFeatures) {
				RoleFeature roleFeatureTOInsert = new RoleFeature();
				roleFeatureTOInsert.setRole(role);
				roleFeatureTOInsert.setFeatureRefId(featureId);
				roleFeaturesToInsert.add(roleFeatureTOInsert);
			}
			roleFeatureRepository.saveAll(roleFeaturesToInsert); // inserting new features while updating role
			return true;
		}
		return false;
	}

}
