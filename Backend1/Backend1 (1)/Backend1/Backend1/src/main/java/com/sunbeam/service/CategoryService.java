package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Category;

public interface CategoryService {
    ApiResponse addCategory(Category category);
    
}
