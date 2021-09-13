package com.shopwithus.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopwithus.models.Item;
import com.shopwithus.repositories.ItemRepository;
import com.shopwithus.services.ItemService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

	@Autowired
	ItemService itemService;

	@Autowired
	ItemRepository itemRepository;

	@GetMapping(path = "/items")
	public @ResponseBody ResponseEntity<Object> getAllItems() {
		List<Item> items = new ArrayList<Item>();
		// items = itemService.getAllItems();
		itemRepository.findAll().forEach(items::add);

		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@GetMapping(path = "/item/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable("id") Long id) {
		Optional<Item> item;
		item = itemService.getItemByID(id);
		return new ResponseEntity<Item>(item.get(), HttpStatus.OK);

	}
	
	@PostMapping(path = "/item/add")
	public @ResponseBody ResponseEntity<Object> addItem(@RequestBody Item item) {
		Item itemAdded = new Item();
		itemAdded = itemService.addItem(item);
		return new ResponseEntity<>(itemAdded, HttpStatus.OK);
	}


	@DeleteMapping(path = "/item/{id}/delete")
	public @ResponseBody ResponseEntity<Long> deleteItemById(@PathVariable("id") Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path = "/item/{id}/update")
	public @ResponseBody ResponseEntity<Object> updateItemById(@RequestBody Item item)
	{
		Long itemID = item.getId();
		Optional<Item> optionalItemToUpdate;
		Item itemToUpdate = new Item();
		Item updatedItem = new Item();
		
		optionalItemToUpdate = itemService.getItemByID(itemID);
		
		itemToUpdate = optionalItemToUpdate.get();
		itemToUpdate.setName(item.getName());
		itemToUpdate.setContent(item.getContent());
		
		updatedItem = itemService.addItem(itemToUpdate);
		
		return new ResponseEntity<>(updatedItem, HttpStatus.OK);
		
	}

}
