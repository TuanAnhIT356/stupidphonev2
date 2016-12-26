package com.dhl.blahblah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhl.blahblah.dao.IProductDetailDAO;
import com.dhl.blahblah.model.ProductDetail;
import com.dhl.blahblah.service.IProductDetailService;

@Service
public class ProductDetailServiceImpl implements IProductDetailService{

	@Autowired
	IProductDetailDAO productDetailDAO;

	@Override
	@Transactional
	public ProductDetail get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public ProductDetail update(ProductDetail productDetail) {
		return productDetailDAO.update(productDetail);
	}
}
