package com.sunbeam.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CartDto;
import com.sunbeam.dto.OrderDto;
import com.sunbeam.entities.Cart;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Item;
import com.sunbeam.service.CartService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
//	 @GetMapping
//	    public ResponseEntity<List<CartDto>> getAllItems() {
//	        return new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.OK);
//	    }
	
	@PostMapping
	public ResponseEntity<?> addNewItemToCart(@RequestBody OrderDto orderDto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addItemToCart(orderDto));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	 
	 @GetMapping
		public List<Cart> listCategories() {
			return cartService.getAllCarts();
		}

	 
	    @GetMapping("/{cartId}")
	    public ResponseEntity<Cart> getItemById(@PathVariable Long cartId) {
	        Optional<Cart> item = cartService.getCartById(cartId);
	        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

//	    @PostMapping
//	    public ResponseEntity<Cart> addItem(@RequestBody Cart cartItem) {
//	        return new ResponseEntity<>(cartService.saveCart(cartItem), HttpStatus.CREATED);
//	    }

//	    @PostMapping
//	    public ResponseEntity<CartDto> addItemToCart(@RequestBody CartDto cartItem) {
//	        CartDto addedItem = cartService.saveCart(cartItem);
//	        return new ResponseEntity<>(addedItem, HttpStatus.CREATED);
//	    }

	    
//	    @PostMapping("/{cartId}/items")
//	    public ApiResponse addItemToCart(@PathVariable Long cartId, @RequestBody Item item) {
//	        cartService.addItemToCart(null));
//			return new ApiResponse("New item  Added to cart!!");
//	    }
	    
//	    @PostMapping("/{cartId}/items")
//	    public ResponseEntity<Item> addItemToCart(@PathVariable Long cartId, @RequestBody Item item) {
//	        Item addedItem = cartService.addItemToCart(cartId, item);
//	        return ResponseEntity.ok(addedItem);
//	    }
	    
	    @PostMapping("/{itemId}")
		public ResponseEntity<?> addNewVehicle(@RequestBody  CartDto dto,@PathVariable  Long itemId)
		{
			try
			{
				return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addItemToCart(dto, itemId));
			}catch(Exception e)
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			}
		}


	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
	    	cartService.deleteCart(id);
	        return ResponseEntity.noContent().build();
	    }
	    
//	    @PutMapping("/{id}")
//	    public ResponseEntity<Cart> updateItem(@PathVariable Long id, @RequestBody Cart cartItem) {
//	        Cart updatedItem = cartService.updateItem(id, cartItem);
//	        return updatedItem != null ? ResponseEntity.ok(updatedItem) : ResponseEntity.notFound().build();
//	    }
	

}
