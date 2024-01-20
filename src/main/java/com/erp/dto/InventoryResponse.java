package com.erp.dto;



public class InventoryResponse {
	
	private Long id;
	private Long itemId;
	private String itemName;
	private Long quantity;
	private String status;
	private String itemCategory;
	
	
	public Long getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	

}
