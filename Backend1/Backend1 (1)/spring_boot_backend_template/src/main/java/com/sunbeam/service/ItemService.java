package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CartDto;
import com.sunbeam.dto.ItemAddDto;

public interface ItemService {
      ApiResponse addItem(ItemAddDto dto, Long categoryId);
      
     // ApiResponse addItemToCart(CartDto dto, Long itemId);

}
