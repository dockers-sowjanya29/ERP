package com.erp.dto;

public class InventoryOptions {
	
	private Long inventoryId;
	private String inventoryName;
	private Long availableQuantity;
	
	public Long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public Long getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

}
