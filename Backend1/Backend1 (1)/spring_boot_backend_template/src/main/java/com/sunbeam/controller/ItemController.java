package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.CartDto;
import com.sunbeam.dto.ItemAddDto;
import com.sunbeam.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping("/{categoryId}")
	public ResponseEntity<?> addNewItem(@RequestBody ItemAddDto dto, @PathVariable Long categoryId){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(itemService.addItem(dto, categoryId));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
//	@PostMapping("/{cartId}")
//	public ResponseEntity<?> addNewItemToCart(@RequestBody  CartDto dto,@PathVariable  Long cartId)
//	{
//		try
//		{
//			return ResponseEntity.status(HttpStatus.CREATED).body(itemService.addItemToCart(dto, cartId));
//		}catch(Exception e)
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//		}
//	}
}
