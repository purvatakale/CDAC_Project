package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ItemAddDto;

public interface ItemService {
      ApiResponse addItem(ItemAddDto dto, Long categoryId);
}
