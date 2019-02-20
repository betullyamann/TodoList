package com.example.todolist.dao;

import java.util.List;

import com.example.todolist.model.Item;


public interface ItemDao {
	
	Item getItem(Integer id);
	
	void addItem(Item item);
	
	List<Item> getItemList();

	void updateItem(Item item);

	void deleteItem(Item item);

}
