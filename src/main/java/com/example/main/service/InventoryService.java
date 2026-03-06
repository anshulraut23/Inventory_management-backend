package com.example.main.service;

import java.util.List;

import com.example.main.entity.InventoryItem;

public interface InventoryService {

	 InventoryItem addItem(InventoryItem it);
	
	 List<InventoryItem> getAllItems();
	
	 InventoryItem getItemById(Long id);
	
	 InventoryItem updateItem(Long id , InventoryItem it);
	
	 public void deleteItem(Long id);
}
