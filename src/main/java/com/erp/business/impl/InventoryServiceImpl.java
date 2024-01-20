package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.InventoryService;
import com.erp.dto.InventoryRequest;
import com.erp.dto.InventoryResponse;
import com.erp.dto.NameValuePair;
import com.erp.entity.Inventory;
import com.erp.repository.InventoryRepository;
import com.erp.repository.IssueDetailsRepository;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	IssueDetailsRepository issueDetailsRepository;
	
	
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


	@Override
	public List<InventoryResponse> getInventoryList() {
		List<Inventory> listInventories=inventoryRepository.findAll();
		if(listInventories!=null & !listInventories.isEmpty())
		{
			List<InventoryResponse> list=new ArrayList<>(); 
			for(Inventory inv: listInventories) {
				InventoryResponse invResponse=new InventoryResponse();
				invResponse.setId(inv.getId());
				invResponse.setItemId(inv.getItemId());
				invResponse.setItemName(inv.getItemName());
				invResponse.setItemCategory(inv.getItemCategory());
				Long inventoryQuantity=inv.getQuantity();
				invResponse.setQuantity(inventoryQuantity);
				Long issueQuantity=issueDetailsRepository.getIssueQuantityByInventoryID(inv.getId());
				
				System.out.println("issueQuantity--->>"+issueQuantity);
				if(issueQuantity!=null && issueQuantity>0 ) {
					
					
				
						if(inventoryQuantity>issueQuantity)
						{
							invResponse.setStatus("In Stock");
						}
						else
						{
							invResponse.setStatus("Out Of Stock");
				         }
				}
				else {
					invResponse.setStatus("Pending");
				}
				
				list.add(invResponse);
			}
			return list;
		}
		
		return null;
	}
	

}
