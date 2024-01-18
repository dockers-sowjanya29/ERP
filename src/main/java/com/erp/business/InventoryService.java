package com.erp.business;

import java.util.List;

import com.erp.dto.InventoryRequest;
import com.erp.dto.NameValuePair;

public interface InventoryService {
	
public String saveInventory(InventoryRequest inventoryRequest);

public List<NameValuePair> getInventoryOptions();

}