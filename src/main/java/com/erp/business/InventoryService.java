package com.erp.business;

import java.util.List;

import com.erp.dto.InventoryRequest;
import com.erp.dto.InventoryResponse;
import com.erp.dto.NameValuePair;

public interface InventoryService {
	
public long saveInventory(InventoryRequest inventoryRequest);

public List<NameValuePair> getInventoryOptions();
public List<InventoryResponse> getInventoryList();
public boolean deleteInventory(Long inventoryId);
public String uplaodImage(Long inventoryId, byte[] imageContent);

}
