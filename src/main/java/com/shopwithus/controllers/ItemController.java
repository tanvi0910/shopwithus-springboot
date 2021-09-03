package com.shopwithus.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		//items = itemService.getAllItems();
		itemRepository.findAll().forEach(items::add);
		
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
	@GetMapping(path="/items/{name}")
	public ResponseEntity<List<Item>> getItemByName(@PathVariable("name") String name)
	{
		List<Item> items = new ArrayList<Item>();
		items = itemRepository.findByName(name);
		System.out.println(items.toString());
		return new ResponseEntity<>(items,HttpStatus.OK);
		
	}
	

}
