package com.example.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.entity.InventoryItem;
import com.example.main.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inrepo;
	
	
	@Override
	public InventoryItem addItem(InventoryItem it) {
		// TODO Auto-generated method stub
		return inrepo.save(it);
		
	}

	@Override
	public List<InventoryItem> getAllItems() {
		// TODO Auto-generated method stub
		return inrepo.findAll();
	}

	@Override
	public InventoryItem getItemById(Long id) {
		// TODO Auto-generated method stub
		
		return inrepo.findById(id).orElse(null);
		
	}

	@Override
	public InventoryItem updateItem(Long id, InventoryItem it) {

		InventoryItem i = inrepo.findById(id).orElse(null);
		
		if(i==null)
		{
			return null;
		}
		
		i.setName(it.getName());
		i.setCategory(it.getCategory());
		i.setQuantity(it.getQuantity());
		i.setPrice(it.getPrice());
		i.setSupplier(it.getSupplier());
		i.setDescription(it.getDescription());
		
		return inrepo.save(i);
		
	}

	
	@Override
	public void deleteItem(Long id) {
		
		inrepo.deleteById(id);
		
	}

	
}
