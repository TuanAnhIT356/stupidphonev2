package com.dhl.blahblah.dao;

import java.util.List;

import com.dhl.blahblah.model.Product;

public interface IProductDAO {
	public List<Product> getAll();
	public Product getById(int id);
	public List<Product> getTopProducts(String type, int num);
	public List<Product> getProductByBrand(String brandName);
	public Product insert(Product product);
	public Product update(Product product);
	public void delete(Product product);
}
