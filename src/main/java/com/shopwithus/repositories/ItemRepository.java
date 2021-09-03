package com.shopwithus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopwithus.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	@Query(value="SELECT * FROM items i where i.name = ?1",nativeQuery = true)
	List<Item> findByName(String name);

}
