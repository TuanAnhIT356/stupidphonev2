package com.dhl.blahblah.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhl.blahblah.dao.IProductDetailDAO;
import com.dhl.blahblah.model.ProductDetail;

@Repository
public class ProductDetailDAOImpl implements IProductDetailDAO {

	@Autowired
	SessionFactory sessionFactory;

	public ProductDetail get(int id){
		return sessionFactory.getCurrentSession().get(ProductDetail.class, id);
	}
	
	@Override
	public ProductDetail update(ProductDetail productDetail) {
		sessionFactory.getCurrentSession().update(productDetail);
		return productDetail;
	}

}
