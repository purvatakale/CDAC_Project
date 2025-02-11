package com.sunbeam.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.custom_exception.ResourceNotFoundException;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.ItemDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ItemAddDto;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao itemDao;
	
	@Autowired 
	private CategoryDao categoryDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addItem(ItemAddDto dto, Long categoryId) {
		Category category = categoryDao.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Invalid Id"));
		Item item = mapper.map(dto, Item.class);
		item.setCategory(category);
		itemDao.save(item);
		return new ApiResponse("New Item added !!");
	}
	
	
}
