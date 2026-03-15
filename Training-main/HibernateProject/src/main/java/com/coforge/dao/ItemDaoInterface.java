package com.coforge.dao;

import java.util.List;

import com.coforge.entities.Item;

public interface ItemDaoInterface {

	List<Item> getAllItems();

	void insertItem(Item item);

	void updateItem(Item item);

	void deleteItem(Item item);

	void getById(long id);
	
	
	
}
