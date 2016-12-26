package com.dhl.blahblah.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhl.blahblah.dao.ITestDAO;
import com.dhl.blahblah.model.CartDetail;


@Repository
public class TestDAOImpl implements ITestDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void test(Object object){
		CartDetail cartDetail = (CartDetail) object;
		sessionFactory.getCurrentSession().save(cartDetail);
	}

}
