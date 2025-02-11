package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;
    
    @Column(name = "item_name")
    private String itemName;
    
    private Float price;
    
    @Column(name = "item_desc")
    private String itemDesc;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    
//    @Lob 
//    @Column(name = "item_image")
//	private byte[] itemImage;
    
    private String itemImagePath;
    
    public Item() {
		// TODO Auto-generated constructor stub
	}
    

	public Item(Long itemId, String itemName, Float price, String itemDesc, Category category) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.itemDesc = itemDesc;
		this.category = category;
		
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	public String getItemImagePath() {
		return itemImagePath;
	}

	public void setItemImagePath(String itemImagePath) {
		this.itemImagePath = itemImagePath;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}
  
	
}
