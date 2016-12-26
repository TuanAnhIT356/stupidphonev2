package com.dhl.blahblah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhl.blahblah.dao.IUserRoleDAO;
import com.dhl.blahblah.model.UserRole;
import com.dhl.blahblah.service.IUserRoleService;

@Service
public class UserRoleService implements IUserRoleService {

	@Autowired
	IUserRoleDAO userRoleDAO;
	
	@Override
	@Transactional
	public void insert(UserRole role) {
		userRoleDAO.insert(role);
	}

}
