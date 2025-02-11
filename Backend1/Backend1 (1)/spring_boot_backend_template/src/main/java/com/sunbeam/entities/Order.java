package com.sunbeam.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "order_id")
	 private Long orderId;
	 
	 @Column(name = "total_amount")
	 private Float totalAmount;
	 
	 @Column(name = "o_date")
	 private LocalDate odate;
	 
	 @Column(name = "order_quantity")
	 private Integer orderQuantity;

//	 @ManyToOne
//	 @JoinColumn(name = "user_id")
//	 private User user;

//	 @OneToOne(mappedBy = "order")
//	 private Delivery delivery;

	 @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	 private Payment payment;

//	 @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//	 private List<Cart> cartItems; 
	 
	  @OneToOne
	  @JoinColumn(name = "cart_id")
	  private Cart cart;

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Order(Long orderId, Float totalAmount, LocalDate odate, Integer orderQuantity, User user,
			Delivery delivery) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.odate = odate;
		this.orderQuantity = orderQuantity;
//		this.user = user;
//		this.delivery = delivery;
	}


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getOdate() {
		return odate;
	}

	public void setOdate(LocalDate odate) {
		this.odate = odate;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}


}
