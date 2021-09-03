package com.shopwithus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwithus.models.Item;
import com.shopwithus.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> getAllItems()
	{
		List<Item> items;
		items = itemRepository.findAll();
		return items;
	}
	
}
