package com.dhl.blahblah.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhl.blahblah.dao.IAccountDAO;
import com.dhl.blahblah.model.Account;

@Repository
public class AccountDAOImpl implements IAccountDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Account login(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query<Account> query = session.createQuery("from Account where username=:username and password = MD5(:password)", Account.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		List<Account> result = query.getResultList();
		return result.size() <=0 ? null : result.get(0);
	}

	@Override
	public int changePassword(String username, String oldPassword, String newPassword) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Account> query = session.createQuery("update from Account set password = MD5(:newPassword) where username = :username and password = MD5(:oldPassword)");
		query.setParameter("newPassword", newPassword);
		query.setParameter("username", username);
		query.setParameter("oldPassword", oldPassword);
		return query.executeUpdate();
	}

	@Override
	public Account register(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings({ "unchecked"})
		Query<Account> query = session.createNativeQuery("insert into Account(username, password) values(:username,MD5(:password))");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.executeUpdate();
		return session.get(Account.class, username);
	}

}
