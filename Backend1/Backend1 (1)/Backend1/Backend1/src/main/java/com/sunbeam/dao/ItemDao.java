package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Item;

public interface ItemDao extends JpaRepository<Item, Long>{

}
