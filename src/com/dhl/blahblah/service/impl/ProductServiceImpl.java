package com.dhl.blahblah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhl.blahblah.dao.IImageDAO;
import com.dhl.blahblah.dao.IProductDAO;
import com.dhl.blahblah.model.Product;
import com.dhl.blahblah.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductDAO productDAO;

	@Autowired
	IImageDAO imageDAO;

	@Override
	@Transactional
	public List<Product> getAll() {
		return productDAO.getAll();
	}
	
	@Override
	@Transactional
	public Product getById(int id) {
		return productDAO.getById(id);
	}
	
	@Override
	@Transactional
	public List<Product> getTopProducts(String type, int num) {
		return productDAO.getTopProducts(type, num);
	}

	@Override
	@Transactional
	public List<Product> getProductByBrand(String brandName) {
		return productDAO.getProductByBrand(brandName);
	}
	
	@Override
	@Transactional
	public Product insert(Product product) {
		return productDAO.insert(product);
	}
	
	@Override
	@Transactional
	public void delete(Product product) {
		productDAO.delete(product);
	}

	@Override
	@Transactional
	public Product update(Product product) {
		return productDAO.update(product);
	}
}
