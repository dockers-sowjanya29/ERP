package com.erp.business.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.InventoryService;
import com.erp.dto.InventoryRequest;
import com.erp.dto.IssueDetailsRequest;
import com.erp.entity.Inventory;
import com.erp.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepository;
	
	
	@Override
	public String  saveInventory(InventoryRequest inventoryRequest) {
		
		Inventory inventory=null;
		if(inventoryRequest!=null)
		{
			inventory=new Inventory();
			BeanUtils.copyProperties(inventoryRequest, inventory);
			inventoryRepository.save(inventory);
			return "data saved successfully";
		}
		return null;
	}
	

}
