package com.example.todolist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.example.todolist.model.User;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
    private EntityManager entityManager;
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    
	@Override
	public User getUser(Integer id) {
		User user = (User)getSession().get(User.class, id);
		return user;
	}

	@Override
	public void addUser(User user) {
		getSession().save(user);
		logger.info("User saved successfully, User Details= " + user);	
	}
	
	@Override
	public List<User> getUserList() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		return entityManager.createQuery(criteria).getResultList();		 
	}

	@Override
	public void updateUser(User user) {
			getSession().update(user);
			logger.info("Person updated successfully, Person Details=" + user);	
	}

	@Override
	public void deleteUser(User user) {
		getSession().delete(user);
		logger.info("User deleted successfully, user details=" + user);
	}

	
}
