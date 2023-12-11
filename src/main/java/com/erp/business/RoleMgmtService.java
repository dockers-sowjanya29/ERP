package com.erp.business;

import java.util.List;

import com.erp.dto.RoleRequest;
import com.erp.dto.RoleResponse;

public interface RoleMgmtService {

	
	public String createRole(RoleRequest request);
	
	public List<RoleResponse> loadAllRoles(RoleRequest request);
	
	public String deleteRole(Long roleId);
}
