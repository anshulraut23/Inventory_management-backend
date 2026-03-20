package com.example.main.service;

import java.util.List;
import com.example.main.entity.InventoryItem;

public interface InventoryService {

    InventoryItem addItem(InventoryItem item);

    List<InventoryItem> getAllItems();

    InventoryItem getItemById(Long id);

    InventoryItem updateItem(Long id, InventoryItem item);

    void deleteItem(Long id);

    List<InventoryItem> searchItems(String keyword);

}