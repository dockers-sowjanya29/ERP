package com.erp.business;

import java.util.List;

import com.erp.dto.InventoryOptions;
import com.erp.dto.InventoryRequest;
import com.erp.dto.InventoryResponse;

public interface InventoryService {
	
public long saveInventory(InventoryRequest inventoryRequest);

public List<InventoryOptions> getInventoryOptions();
public List<InventoryResponse> getInventoryList();
public boolean deleteInventory(Long inventoryId);
public String uplaodImage(Long inventoryId, byte[] imageContent);

}
