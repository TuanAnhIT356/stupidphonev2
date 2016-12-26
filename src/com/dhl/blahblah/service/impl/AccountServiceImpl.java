package com.dhl.blahblah.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhl.blahblah.dao.IAccountDAO;
import com.dhl.blahblah.dao.IUserRoleDAO;
import com.dhl.blahblah.model.Account;
import com.dhl.blahblah.model.UserRole;
import com.dhl.blahblah.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	IAccountDAO accountDAO;
	
	@Autowired
	IUserRoleDAO userRoleDAO;
	
	@Override
	@Transactional
	public Account login(String username, String password) {
		Account account = accountDAO.login(username, password);
		if(account != null)
			System.out.print(account.getListCart());
		return account;
	}

	@Override
	@Transactional
	public int changePassword(String username, String oldPassword, String newPassword) {
		return accountDAO.changePassword(username, oldPassword, newPassword);
	}

	@Override
	@Transactional
	public Account register(String username, String password) {
		Account account = accountDAO.register(username, password);
		if(account != null){
			UserRole role = new UserRole(account,"customer");
			userRoleDAO.insert(role);
			List<UserRole> listRole = new ArrayList<UserRole>();
			listRole.add(role);
			account.setUserRole(listRole);
		}
		return account;
	}
	
	
}
