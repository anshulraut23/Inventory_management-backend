package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.entity.InventoryItem;
import com.example.main.service.InventoryService;
import com.example.main.service.InventoryServiceImpl;


@RestController
@RequestMapping("/api/inventory")
@CrossOrigin
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Add Item
    @PostMapping("/items")
    public ResponseEntity<InventoryItem> addItem(@RequestBody InventoryItem item) {
        InventoryItem savedItem = inventoryService.addItem(item);
        return ResponseEntity.ok(savedItem);
    }

    // Get All Items
    @GetMapping("/items")
    public ResponseEntity<List<InventoryItem>> getAllItems() {
        return ResponseEntity.ok(inventoryService.getAllItems());
    }

    // Get Item By ID
    @GetMapping("/items/{id}")
    public ResponseEntity<InventoryItem> getItemById(@PathVariable Long id) {
        InventoryItem item = inventoryService.getItemById(id);

        if(item == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(item);
    }

    // Update Item
    @PutMapping("/items/{id}")
    public ResponseEntity<InventoryItem> updateItem(@PathVariable Long id,
                                                    @RequestBody InventoryItem item) {

        InventoryItem updated = inventoryService.updateItem(id, item);

        if(updated == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }

    // Delete Item
    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        inventoryService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}