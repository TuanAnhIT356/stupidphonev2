package com.dhl.blahblah.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhl.blahblah.dao.IProducerDAO;
import com.dhl.blahblah.model.Producer;

@Repository
public class ProducerDAOImpl implements IProducerDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Producer> getAll() {
		Query<Producer> query = sessionFactory.getCurrentSession().createQuery("from Producer", Producer.class);
		return query.getResultList();
	}

}
