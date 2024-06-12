package com.erp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.erp.business.InventoryService;
import com.erp.dto.InventoryOptions;
import com.erp.dto.InventoryRequest;
import com.erp.dto.InventoryResponse;

@RestController
@RequestMapping("controller/erp/inventory")
//@CrossOrigin(origins = "http://localhost:4200")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	@RequestMapping(value = "/saveInventory", method = RequestMethod.POST)
	public long saveInventory(@RequestBody InventoryRequest inventoryRequest) {
		//System.out.println("in inv save---->>"+inventoryRequest.getItemImage1().getName());
		return inventoryService.saveInventory(inventoryRequest);
	}

	@RequestMapping(value = "/uplaodImage", method = RequestMethod.POST)
	public String uplaodImage(@RequestParam("itemImage") MultipartFile itemImage) throws IOException {
		try {
			Long inventoryId = Long.parseLong(itemImage.getOriginalFilename());
			return inventoryService.uplaodImage(inventoryId, itemImage.getBytes());
		}catch(NumberFormatException nfe) {
			System.out.println("Invalid Inventory Id");
		}
		System.out.println(itemImage.getOriginalFilename());
		return "Error while saving data";
	}

	@RequestMapping(value = "/getInventoryOptions", method = RequestMethod.GET)
	public List<InventoryOptions> getInventoryOptions() {
		return inventoryService.getInventoryOptions();
	}

	@RequestMapping(value = "/getInventoryList", method = RequestMethod.GET)
	public List<InventoryResponse> getInventoryList() {
		return inventoryService.getInventoryList();
	}

	@RequestMapping(value = "/deleteInventory", method = RequestMethod.POST)
	public boolean deleteInventory(@RequestBody Long inventoryId) {
		System.out.println("inventoryId--->" + inventoryId);
		return inventoryService.deleteInventory(inventoryId);
	}

}
