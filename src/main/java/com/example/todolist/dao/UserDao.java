package com.example.todolist.dao;

import java.util.List;

import com.example.todolist.model.User;

public interface UserDao {
	
	User getUser(Integer id);
	
	void addUser(User user);
	
	List<User> getUserList();

	void updateUser(User user);

	void deleteUser(User user);

}
