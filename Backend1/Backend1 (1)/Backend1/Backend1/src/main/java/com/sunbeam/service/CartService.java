package com.sunbeam.service;

import com.sunbeam.entities.Cart;
import com.sunbeam.entities.Item;

public interface CartService {

	public Cart addItemToCart(Long cartId, Item cartItem);
}
