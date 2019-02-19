package com.example.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todolist.dao.UserDao;
import com.example.todolist.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	//@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

	@Override
	public void addUser(User user) {
		this.userDao.addUser(user);		
	}

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);		
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);		
	}
}
