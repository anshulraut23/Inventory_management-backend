package com.example.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.entity.InventoryItem;
import com.example.main.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository repository;

    @Override
    public InventoryItem addItem(InventoryItem item) {
        return repository.save(item);
    }

    @Override
    public List<InventoryItem> getAllItems() {
        return repository.findAll();
    }

    @Override
    public InventoryItem getItemById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public InventoryItem updateItem(Long id, InventoryItem item) {

        InventoryItem existing = repository.findById(id).orElse(null);

        if(existing == null) {
            return null;
        }

        existing.setName(item.getName());
        existing.setCategory(item.getCategory());
        existing.setQuantity(item.getQuantity());
        existing.setPrice(item.getPrice());
        existing.setSupplier(item.getSupplier());
        existing.setDescription(item.getDescription());

        return repository.save(existing);
    }

    @Override
    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<InventoryItem> searchItems(String keyword) {

        return repository.findAll().stream()
                .filter(item -> item.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}