package com.hccs.advweb;

import java.util.ArrayList;

public class Items {
	
	private ArrayList<Item> items;
	
	// Default Constructor
	public Items() {
		
	}

	public ArrayList<Item> getItems() {
		items = new ArrayList<Item>();
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}	
	
}
