package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.business.impl.RoleMgmtServiceImpl;
import com.erp.dto.RoleRequest;
import com.erp.dto.RoleResponse;

@RestController
@RequestMapping("controller/erp/role")
@CrossOrigin(origins="http://localhost:4200")

public class RoleController {

	@Autowired
	RoleMgmtServiceImpl roleMgmtServiceImpl;

	@RequestMapping(value = "/createRole", method = RequestMethod.POST)
	public String createRole(@RequestBody RoleRequest request) {
		return roleMgmtServiceImpl.createRole(request);
	}
	
	
	@RequestMapping(value = "/loadAllRoles", method = RequestMethod.POST)
	public List<RoleResponse> loadAllRoles(@RequestBody RoleRequest request) {
		return roleMgmtServiceImpl.loadAllRoles(request);
	}

	

	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	public String deleteRole(@RequestBody Long roleId) {
		return roleMgmtServiceImpl.deleteRole(roleId);
	}
}
