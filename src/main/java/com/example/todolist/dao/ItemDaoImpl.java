package com.example.todolist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.todolist.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
    private EntityManager entityManager;
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
	
	private static final Logger logger = LoggerFactory.getLogger(ItemDaoImpl.class);
    
	@Override
	public Item getItem(Integer id) {
		Item item = (Item)getSession().get(Item.class, id);
		return item;
	}

	@Override
	public void addItem(Item item) {
		getSession().save(item);
		logger.info("Item saved successfully, Item Details= " + item);	
	}
	
	@Override
	public List<Item> getItemList() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Item> criteria = builder.createQuery(Item.class);
		return entityManager.createQuery(criteria).getResultList();		 
	}

	@Override
	public void updateItem(Item item) {
			getSession().update(item);
			logger.info("Person updated successfully, Person Details=" + item);	
	}

	@Override
	public void deleteItem(Item item) {
		getSession().delete(item);
		logger.info("Item deleted successfully, item details=" + item);
	}

}
