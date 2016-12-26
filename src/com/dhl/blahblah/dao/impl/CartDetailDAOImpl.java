package com.dhl.blahblah.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhl.blahblah.dao.ICartDetailDAO;
import com.dhl.blahblah.model.CartDetail;

@Repository
public class CartDetailDAOImpl implements ICartDetailDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void delete(int cartId) {
		@SuppressWarnings("unchecked")
		Query<CartDetail> query = sessionFactory.getCurrentSession().createQuery("delete from CartDetail where cart_id=:cartId");
		query.setParameter("cartId", cartId);
		query.executeUpdate();
	}

	@Override
	public boolean findByProduct(int productId){
		Query<CartDetail> query = sessionFactory.getCurrentSession().createQuery("from CartDetail where product_id=:productId",CartDetail.class);
		query.setParameter("productId", productId);
		List<CartDetail> result = query.getResultList();
		return result.size() > 0;
	}
}
