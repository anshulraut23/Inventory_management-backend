package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.entity.InventoryItem;

public interface InventoryRepository extends JpaRepository<InventoryItem,Long>
{
	
}

