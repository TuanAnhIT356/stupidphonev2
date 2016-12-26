package com.dhl.blahblah.service;

import com.dhl.blahblah.model.Cart;

public interface ICartService {
	public Cart get(int id);
	public Cart insert(Cart cart);
	public Cart update(Cart cart);
	public void delete(Cart cart);
	public boolean findByProduct(int productId);
}
