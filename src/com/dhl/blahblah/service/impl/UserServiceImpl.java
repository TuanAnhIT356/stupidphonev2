package com.dhl.blahblah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhl.blahblah.dao.IUserDAO;
import com.dhl.blahblah.model.User;
import com.dhl.blahblah.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDAO userDAO;
	
	@Override
	@Transactional
	public void test() {
		User user = new User();
		user.setId(7);
		user.setAddress("abc abc");
		user.setName("Test update");
		user.setPhoneNumber("01686667071");
		user.setSex("Nam");
		userDAO.update(user);
	}

	@Override
	@Transactional
	public User insert(User user) {
		return userDAO.insert(user);
	}
	
	@Override
	@Transactional
	public User update(User user) {
		return userDAO.update(user);
	}

}
