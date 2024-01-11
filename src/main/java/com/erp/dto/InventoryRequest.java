package com.erp.dto;

import java.util.List;

public class InventoryRequest {
	
	
	private Long id;
	//private List<IssueDetailsRequest> issueDetailsRequests = null;
	private Long itemId;
	private String itemName;
	private byte[] itemImage;
	private String itemCategory;
	private Float price;
	private Long quantity;
	
	public Long getId() {
		return id;
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
	public byte[] getItemImage() {
		return itemImage;
	}
	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
