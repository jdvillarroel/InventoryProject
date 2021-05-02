package com.hccs.advweb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1")
@CrossOrigin
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@GetMapping
	public List<Item> getItems() {
		return itemService.getItems();
	}
	
	@PostMapping(path = "/addItem", consumes = "application/json")
	public void addItem(@RequestBody Item item) {
		System.out.println("From Controller: ");
		System.out.println(item);
		itemService.addItem(item);
	}

	@DeleteMapping(path="/deleteItem/{id}")
	public void deleteItem(@PathVariable int id) {
		itemService.deleteItem(id);
	}
}
