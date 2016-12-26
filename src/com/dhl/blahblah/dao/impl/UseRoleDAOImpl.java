package com.dhl.blahblah.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhl.blahblah.dao.IUserRoleDAO;
import com.dhl.blahblah.model.UserRole;

@Repository
public class UseRoleDAOImpl implements IUserRoleDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insert(UserRole role) {
		sessionFactory.getCurrentSession().save(role);
	}

}
