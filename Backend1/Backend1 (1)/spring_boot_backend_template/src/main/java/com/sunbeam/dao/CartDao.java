package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.dto.OrderDto;
import com.sunbeam.entities.Cart;
import com.sunbeam.entities.Item;

public interface CartDao extends  JpaRepository<Cart, Long>{

	void save(OrderDto orderDto);

}
