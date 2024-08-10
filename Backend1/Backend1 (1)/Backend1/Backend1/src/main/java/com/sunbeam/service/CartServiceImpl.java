package com.sunbeam.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.CartDao;
import com.sunbeam.entities.Cart;
import com.sunbeam.entities.Item;

@Service
@Transactional
public class CartServiceImpl implements CartService{

	@Override
	public Cart addItemToCart(Long cartId, Item cartItem) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
