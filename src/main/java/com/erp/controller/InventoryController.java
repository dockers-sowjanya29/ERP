package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.business.InventoryService;
import com.erp.dto.InventoryRequest;
import com.erp.dto.InventoryResponse;
import com.erp.dto.NameValuePair;

@RestController
@RequestMapping("controller/erp/inventory")
@CrossOrigin(origins = "http://localhost:4200")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;

	@RequestMapping(value = "/saveInventory", method = RequestMethod.POST)
	public String saveInventory(@RequestBody InventoryRequest inventoryRequest) {
		return inventoryService.saveInventory(inventoryRequest);
	}
	
	
	@RequestMapping(value = "/getInventoryOptions", method = RequestMethod.GET)
	public List<NameValuePair> getInventoryOptions() {
		return inventoryService.getInventoryOptions();
	}
	
	
	@RequestMapping(value = "/getInventoryList", method = RequestMethod.GET)
	public List<InventoryResponse> getInventoryList() {
		return inventoryService.getInventoryList();
	}
	

}
