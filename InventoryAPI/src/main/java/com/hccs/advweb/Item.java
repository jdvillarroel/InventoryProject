package com.hccs.advweb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

	@Id
	@Column(name="ID")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemID;
	
	@Column(name="QTY")
	private int qty;
	
	@Column(name="NAME")
	private String itemName;
	
	@Column(name="DESCRIPTION")
	private String itemDescription;
	
	public Item() {
		
	}
	
	public Item(int _itemID, String _itemName, String _itemDescription, int _qty) {
		itemID = _itemID;
		qty = _qty;
		itemName = _itemName;
		itemDescription = _itemDescription;
	}
	
	public Item(String _itemName, String _itemDescription, int _qty) {
		qty = _qty;
		itemName = _itemName;
		itemDescription = _itemDescription;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", qty=" + qty + ", itemName=" + itemName + ", itemDescription="
				+ itemDescription + "]";
	}

	

}