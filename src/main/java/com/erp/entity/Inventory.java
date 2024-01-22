package com.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Inventory_details")
public class Inventory {

	
	@Id
	@Column(name = "INVENTORY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVENTORY_ID_SEQUENCE")
	@SequenceGenerator(name = "INVENTORY_ID_SEQUENCE", sequenceName = "INVENTORY_ID_SEQUENCE", allocationSize = 1)
	private Long id;

	
	@Column(name = "ITEM_ID")
	private String itemId;

	@Column(name = "ITEM_NAME")
	private String itemName;

	 @Lob
	 @Column(name = "ITEM_IMAGE", length = 1000)
	private  byte[] itemImage;	

	

	@Column(name = "ITEM_CATEGORY")
	private String itemCategory;
	
	
	@Column(name = "PRICE")
	private Float price;
	
	
	@Column(name="QUANTITY")
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