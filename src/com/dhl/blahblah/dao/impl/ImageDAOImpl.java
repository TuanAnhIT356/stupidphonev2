package com.dhl.blahblah.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhl.blahblah.dao.IImageDAO;
import com.dhl.blahblah.model.Image;

@Repository
public class ImageDAOImpl implements IImageDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Image getImageByProductId(int productId, String type) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Image> theQuery = currentSession.createQuery("from Image where product_id=:productId and type=:type",
				Image.class);
		theQuery.setParameter("productId", productId);
		theQuery.setParameter("type", type);

		List<Image> result = theQuery.getResultList();

		if (result.size() > 0)
			return result.get(0);

		return null;
	}

	@Override
	public void insert(Image image) {
		sessionFactory.getCurrentSession().save(image);
	}

	@Override
	public List<Image> getImageByProductId(int productId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Image> theQuery = currentSession.createQuery("from Image where product_id=:productId",
				Image.class);
		theQuery.setParameter("productId", productId);
		List<Image> result = theQuery.getResultList();

		return result;
	}

	@Override
	public void delete(int productId, String type) {
		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from Image where product_id=:productId and type=:type");
		theQuery.setParameter("productId", productId);
		theQuery.setParameter("type", type);
		theQuery.executeUpdate();
	}
}
