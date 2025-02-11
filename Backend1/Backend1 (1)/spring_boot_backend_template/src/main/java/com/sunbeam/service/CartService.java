package com.sunbeam.service;

import java.util.List;

import java.util.Optional;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CartDto;
import com.sunbeam.dto.OrderDto;
import com.sunbeam.entities.Cart;
import com.sunbeam.entities.Item;

public interface CartService {

	List<Cart> getAllCarts();
	
	Optional<Cart> getCartById(Long id);
	
	//Cart saveCart(CartDto cart);
	
	//ApiResponse addItemToCart(Long orderId, String itemName, int itemQuantity);
	
	//ApiResponse addToCartByItemId(Long itemId);
	
	//ApiResponse addItemToCart(Long cartId, Item item);
	
	ApiResponse addItemToCart(OrderDto orderDto);
	
	void deleteCart(Long id);

	//Item addItemToCart(Long cartId, Item item);
	
	ApiResponse addItemToCart(CartDto dto, Long itemId);
	
	//Cart updateItem(Long id, Cart cartItem);
}
