package com.dhl.blahblah.dao;

public interface ICartDetailDAO {
	public void delete(int cartId);
	public boolean findByProduct(int productId);
}
