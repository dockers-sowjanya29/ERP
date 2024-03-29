package com.erp.dto;

public class InventoryRequest {
	
	
	private Long id;
	//private List<IssueDetailsRequest> issueDetailsRequests = null;
	private String itemId;
	private String itemName;
	private byte[] itemImage;
	private Long itemCategoryRefId;

	private Float price;
	private Long quantity;
	
	public Long getId() {
		return id;
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
	public byte[] getItemImage() {
		return itemImage;
	}
	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
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
	
	
	public Long getItemCategoryRefId() {
		return itemCategoryRefId;
	}
	public void setItemCategoryRefId(Long itemCategoryRefId) {
		this.itemCategoryRefId = itemCategoryRefId;
	}
	

}
