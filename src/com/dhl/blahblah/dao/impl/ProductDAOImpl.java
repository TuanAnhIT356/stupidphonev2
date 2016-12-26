package com.dhl.blahblah.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhl.blahblah.dao.IProductDAO;
import com.dhl.blahblah.model.Product;

@Repository
public class ProductDAOImpl implements IProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Product> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("from Product", Product.class);
		List<Product> listProduct = query.getResultList();
		return listProduct;
	}

	@Override
	public Product getById(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public List<Product> getTopProducts(String type, int num) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("from Product order by "+type+" desc", Product.class);
		query.setMaxResults(num);

		List<Product> listProduct = query.getResultList();

		return listProduct;
	}
	

	@Override
	public List<Product> getProductByBrand(String brandName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("from Product where producer.name=:brandName", Product.class);
		query.setParameter("brandName", brandName);

		List<Product> listProduct = query.getResultList();

		return listProduct;
	}

	@Override
	public void delete(Product product) {
		sessionFactory.getCurrentSession().delete(product);
	}

	@Override
	public Product insert(Product product) {
		sessionFactory.getCurrentSession().save(product);
		return product;
	}

	@Override
	public Product update(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return product;
	}
}
