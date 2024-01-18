package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.InventoryService;
import com.erp.dto.InventoryRequest;
import com.erp.dto.NameValuePair;
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


	@Override
	public List<NameValuePair> getInventoryOptions() {
		
		List<Inventory> listInventories=inventoryRepository.findAll();
		
		if(listInventories!=null & !listInventories.isEmpty())
		{
			List<NameValuePair> list=new ArrayList<>(); 
			for(Inventory inv: listInventories) {
				NameValuePair np=new NameValuePair();
				np.setName(inv.getItemName());
				np.setValue(inv.getId().toString());
				list.add(np);
			}
			return list;
		}
		return null;
	}
	

}
