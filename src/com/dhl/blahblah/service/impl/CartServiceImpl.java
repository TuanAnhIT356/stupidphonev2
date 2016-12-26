package com.dhl.blahblah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhl.blahblah.dao.ICartDAO;
import com.dhl.blahblah.dao.ICartDetailDAO;
import com.dhl.blahblah.model.Cart;
import com.dhl.blahblah.model.CartDetail;
import com.dhl.blahblah.service.ICartService;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	ICartDAO cartDAO;
	
	@Autowired
	ICartDetailDAO cartDetailDAO;
	
	@Override
	@Transactional
	public Cart insert(Cart cart) {
		for(CartDetail item : cart.getListItems()){
			item.setCart(cart);
		}
		return cartDAO.insert(cart);
	}

	@Override
	@Transactional
	public Cart update(Cart cart) {
		for(CartDetail item : cart.getListItems()){
			item.setCart(cart);
		}
		return cartDAO.update(cart);
	}
	
	@Override
	@Transactional
	public void delete(Cart cart) {
		cartDetailDAO.delete(cart.getId());
		cartDAO.delete(cart);
	}

	@Override
	@Transactional
	public Cart get(int id) {
		Cart cart = cartDAO.get(id);
		if(cart != null)
			System.out.print(cart.getListItems());
		return cart;
	}

	@Override
	@Transactional
	public boolean findByProduct(int productId) {
		return cartDetailDAO.findByProduct(productId);
	}
}
