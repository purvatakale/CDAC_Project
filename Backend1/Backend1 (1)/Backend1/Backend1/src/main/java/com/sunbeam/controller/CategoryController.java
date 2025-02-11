package com.sunbeam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Category;
import com.sunbeam.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<?> addNewCategory(@RequestBody Category category){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(category));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
