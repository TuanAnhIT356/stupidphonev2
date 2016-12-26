package com.dhl.blahblah.dao;

import com.dhl.blahblah.model.Cart;

public interface ICartDAO {
	public Cart get(int id);
	public Cart insert(Cart cart);
	public Cart update(Cart cart);
	public void delete(Cart cart);
}
