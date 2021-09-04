package com.shopwithus.repositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.shopwithus.models.Item;

public interface ItemRepository extends CrudRepository<Item, Serializable> {
		

}
