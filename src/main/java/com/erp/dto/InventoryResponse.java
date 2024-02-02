package com.erp.dto;



public class InventoryResponse {
	
	private Long id;
	private String itemId;
	private String itemName;
	private Long quantity;
	private String status;
	private Long itemCategoryRefId;
	
	private Float price;
	
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
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
	

	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
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

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Long getItemCategoryRefId() {
		return itemCategoryRefId;
	}
	public void setItemCategoryRefId(Long itemCategoryRefId) {
		this.itemCategoryRefId = itemCategoryRefId;
	}

}
