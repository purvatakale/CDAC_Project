package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sunbeam.custom_exception.ResourceNotFoundException;
import com.sunbeam.dao.CartDao;
import com.sunbeam.dao.ItemDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CartDto;
import com.sunbeam.dto.OrderDto;
import com.sunbeam.entities.Cart;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Item;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	    @Autowired
	    private CartDao cartDao;
	    
	    @Autowired
	    private ItemDao itemDao;
	    
	    @Autowired
	    private  ModelMapper mapper;

	    public List<Cart> getAllCarts() {
	        return cartDao.findAll();
	    }

	    public Optional<Cart> getCartById(Long cartId) {
	        return cartDao.findById(cartId);
	    }

	    @Override
		public ApiResponse addItemToCart(OrderDto orderDto) {
			cartDao.save(orderDto);;
			return new ApiResponse("New item Added !!");
		}
	    

	    public void deleteCart(Long cartId) {
	    	cartDao.deleteById(cartId);
	    }


//	    public ApiResponse addItemToCart(Long cartId, Item item) {
//	    	Cart cart = new Cart();
////	        Cart cart = getCart(cartId);
//	        item.setCart(cart);
//	        cart.getItems().add(item);
//	        cartDao.save(cart);
//			return new ApiResponse("New item Added to cart !!");
//	    }
	    
//	    public Item addItemToCart(CartDto cartDto,Long cartId) {
//	        Cart cart = cartDao.findById(cartId)
//	                .orElseThrow(() -> new RuntimeException("Cart not found"));
//	        item.setCart(cart);
//	        return itemDao.save(item);
//	    }
	    
	    @Override
		public ApiResponse addItemToCart(CartDto dto, Long itemId) {
			
			Item item = itemDao.findById(itemId).orElseThrow(()->new ResourceNotFoundException("Invalid user id"));
		    Cart cart = mapper.map(dto, Cart.class);
			cart.setItem(item);
			cartDao.save(cart);
			return new ApiResponse("New item added!");
		}	    
	    

}
