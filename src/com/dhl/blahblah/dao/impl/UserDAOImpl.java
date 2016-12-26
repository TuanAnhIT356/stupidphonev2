package com.dhl.blahblah.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhl.blahblah.dao.IUserDAO;
import com.dhl.blahblah.model.User;

@Repository
public class UserDAOImpl implements IUserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void test() {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User", User.class);
		List<User> listUser = query.getResultList();
		for (User user : listUser) {
			System.out.println(user);
		}
	}
	
	@Override
	public User insert(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user;
	}
	
	@Override
	public User update(User user){
		sessionFactory.getCurrentSession().update(user);
		return user;
	}	
}
