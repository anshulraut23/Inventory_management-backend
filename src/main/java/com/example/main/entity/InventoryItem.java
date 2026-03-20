package com.example.main.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="inventory_items")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Integer quantity;

    private Double price;

    private String supplier;

    private String description;

    private LocalDateTime createdAt = LocalDateTime.now();

    public InventoryItem() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public String getSupplier() { return supplier; }

    public void setSupplier(String supplier) { this.supplier = supplier; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}