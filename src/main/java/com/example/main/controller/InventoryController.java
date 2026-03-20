package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.main.dto.DashboardStats;
import com.example.main.entity.InventoryItem;
import com.example.main.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping("/items")
    public ResponseEntity<InventoryItem> addItem(@RequestBody InventoryItem item) {
        return ResponseEntity.ok(service.addItem(item));
    }

    @GetMapping("/items")
    public ResponseEntity<List<InventoryItem>> getAllItems() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<InventoryItem> getItem(@PathVariable Long id) {

        InventoryItem item = service.getItemById(id);

        if(item == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(item);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<InventoryItem> updateItem(
            @PathVariable Long id,
            @RequestBody InventoryItem item) {

        InventoryItem updated = service.updateItem(id,item);

        if(updated == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {

        service.deleteItem(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<InventoryItem>> searchItems(
            @RequestParam String keyword) {

        return ResponseEntity.ok(service.searchItems(keyword));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardStats> dashboard() {

        List<InventoryItem> items = service.getAllItems();

        long totalItems = items.size();

        long totalStock = items.stream()
                .mapToLong(i -> i.getQuantity())
                .sum();

        long lowStock = items.stream()
                .filter(i -> i.getQuantity() < 10)
                .count();

        DashboardStats stats = new DashboardStats(
                totalItems,
                totalStock,
                lowStock
        );

        return ResponseEntity.ok(stats);
    }
}