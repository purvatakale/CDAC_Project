package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id") 
    private Set<Item> items = new HashSet<>();
    
    @OneToOne(mappedBy = "cart")
    private Order order;
   
//    @Column(name = "item_name")
//    private String itemName;
//    
//    @Column(name = "item_quantity")
//    private Integer itemQuantity;

//    @ManyToMany
//    @JoinTable(
//        name = "cart_items",
//        joinColumns = @JoinColumn(name = "cart_id"),
//        inverseJoinColumns = @JoinColumn(name = "item_id")
//    )
//    private Set<Item> items;
    
//    @OneToMany(mappedBy = "cartItem",
//			cascade = CascadeType.ALL,orphanRemoval = true) 
//	private List<Item> items = new ArrayList<>();
    

    
//    @OneToMany(mappedBy = "orderId")
////    @JoinColumn(name = "orderId")
//    private Order order;
    
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "order_Id") 
//    private Set<Order> order = new HashSet<>();
    
    
    
    public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Long cartId, Set<Item> items, Order order) {
		super();
		this.cartId = cartId;
		this.items = items;
		this.order = order;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setItem(Item item) {
		// TODO Auto-generated method stub
		
	}


}
