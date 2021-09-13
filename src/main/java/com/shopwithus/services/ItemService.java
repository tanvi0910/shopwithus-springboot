package com.shopwithus.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopwithus.models.Item;
import com.shopwithus.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public Iterable<Item> getAllItems() {
		Iterable<Item> items;
		items = itemRepository.findAll();
		return items;
	}

	public Optional<Item> getItemByID(Long id) {
		return itemRepository.findById(id);
	}

	public Item addItem(Item item) {
		return itemRepository.save(item);
	}

	public void deleteItemById(Long id) {
		itemRepository.deleteById(id);
	}

	public Item updateItemById(Item item) {
		return itemRepository.save(item);
	}

}
