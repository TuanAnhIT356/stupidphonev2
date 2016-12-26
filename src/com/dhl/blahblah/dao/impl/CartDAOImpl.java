package com.dhl.blahblah.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhl.blahblah.dao.ICartDAO;
import com.dhl.blahblah.model.Cart;

@Repository
public class CartDAOImpl implements ICartDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Cart insert(Cart cart) {
		sessionFactory.getCurrentSession().save(cart);
		return cart;
	}

	@Override
	public Cart update(Cart cart) {
		sessionFactory.getCurrentSession().update(cart);
		return cart;
	}

	@Override
	public Cart get(int id) {
		Cart cart = sessionFactory.getCurrentSession().get(Cart.class, id);
		return cart;
	}
	
	@Override
	public void delete(Cart cart) {
		sessionFactory.getCurrentSession().remove(cart);
	}
	
}
