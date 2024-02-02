package com.erp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.business.InventoryService;
import com.erp.dto.InventoryOptions;
import com.erp.dto.InventoryRequest;
import com.erp.dto.InventoryResponse;
import com.erp.dto.NameValuePair;
import com.erp.entity.Inventory;
import com.erp.repository.InventoryRepository;
import com.erp.repository.IssueDetailsRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Autowired
	IssueDetailsRepository issueDetailsRepository;

	@Override
	public long saveInventory(InventoryRequest inventoryRequest) {

		Inventory inventory = null;
		if (inventoryRequest != null) {
			if (inventoryRequest.getId() != null) {
				inventory = getInventory(inventoryRequest.getId());
			}
			else {
				inventory = new Inventory();
			}
			BeanUtils.copyProperties(inventoryRequest, inventory);
			inventory = inventoryRepository.save(inventory);
			if(inventory != null) {
				return inventory.getId();
			}
		}
		return 0;
	}

	@Override
	public List<InventoryOptions> getInventoryOptions() {

		List<Inventory> listInventories = inventoryRepository.findAll();

		if (listInventories != null & !listInventories.isEmpty()) {
			List<InventoryOptions> list = new ArrayList<>();
			for (Inventory inv : listInventories) {
				InventoryOptions np = new InventoryOptions();
				np.setInventoryName(inv.getItemName());
				np.setInventoryId(inv.getId());
				//quantity label
				Long issueQuantity = issueDetailsRepository.getIssueQuantityByInventoryID(inv.getId());
				if(issueQuantity!=null) {
				np.setAvailableQuantity(inv.getQuantity()-issueQuantity);}
				else {
					np.setAvailableQuantity(inv.getQuantity());
				}
				list.add(np);
			}
			return list;
		}
		return null;
	}

	@Override
	public List<InventoryResponse> getInventoryList() {
		List<Inventory> listInventories = inventoryRepository.findAll();
		if (listInventories != null & !listInventories.isEmpty()) {
			List<InventoryResponse> list = new ArrayList<>();
			for (Inventory inv : listInventories) {
				InventoryResponse invResponse = new InventoryResponse();
				invResponse.setId(inv.getId());
				invResponse.setItemId(inv.getItemId());
				invResponse.setItemName(inv.getItemName());
				invResponse.setItemCategoryRefId(inv.getItemCategoryRefId());
				invResponse.setPrice(inv.getPrice());
				Long inventoryQuantity = inv.getQuantity();
				invResponse.setQuantity(inventoryQuantity);
				Long issueQuantity = issueDetailsRepository.getIssueQuantityByInventoryID(inv.getId());

				if (issueQuantity != null && issueQuantity > 0) {

					if (inventoryQuantity > issueQuantity) {
						invResponse.setStatus("In Stock");
					} else {
						invResponse.setStatus("Out Of Stock");
					}
				} else {
					invResponse.setStatus("Pending");
				}

				list.add(invResponse);
			}
			return list;
		}

		return null;
	}

	@Override
	@Transactional
	public boolean deleteInventory(Long inventoryId) {
		Inventory inv = getInventory(inventoryId);
		if (inv != null) {
			issueDetailsRepository.deleteIssueInventory(inv.getId());
			inventoryRepository.delete(inv);
			return true;
		}
		return false;
	}
	
	private Inventory getInventory(Long inventoryId) {
		Optional<Inventory> optInventory = inventoryRepository.findById(inventoryId);
		if (optInventory != null && optInventory.get() != null) {
			return optInventory.get();
		}
		return null;
	}

	@Override
	public String uplaodImage(Long inventoryId, byte[] imageContent) {
		Inventory inv = getInventory(inventoryId);
		if (inv != null) {
			inv.setItemImage(imageContent);
			inventoryRepository.save(inv);
			return "Data saved successfully";
		}
		return null;
	}

}
