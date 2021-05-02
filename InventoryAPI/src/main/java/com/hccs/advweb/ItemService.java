package com.hccs.advweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepo;
	
	public ItemService() {
		
	}

	public List<Item> getItems() {
		return itemRepo.findAll();
	}
	
	public void addItem(Item item) {
		itemRepo.save(item);
	}
	
	public void deleteItem(int id) {
		itemRepo.deleteById(id);
	}
}
