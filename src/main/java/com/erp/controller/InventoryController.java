package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erp.business.InventoryService;
import com.erp.dto.InventoryRequest;

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

}
