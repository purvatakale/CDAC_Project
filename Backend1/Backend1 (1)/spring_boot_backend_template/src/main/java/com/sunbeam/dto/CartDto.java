package com.sunbeam.dto;

public class CartDto {
	
	
    private String itemName;
    
    private Float price;

    private Integer itemQuantity;

    public CartDto() {
		// TODO Auto-generated constructor stub
	}
   


	public CartDto(String itemName, Float price, Integer itemQuantity) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.itemQuantity = itemQuantity;
	}



	public Float getPrice() {
		return price;
	}



	public void setPrice(Float price) {
		this.price = price;
	}



	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

    
}
