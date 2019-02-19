package com.example.todolist.service;

import java.util.List;

import com.example.todolist.model.User;

public interface UserService {
	
	User getUser(Integer id);
	
	public void addUser(User user);
	
	List<User> getUserList();

	void updateUser(User user);

	void deleteUser(User user);
}
