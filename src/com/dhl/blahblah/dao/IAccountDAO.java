package com.dhl.blahblah.dao;

import com.dhl.blahblah.model.Account;

public interface IAccountDAO {
	public Account login(String username, String password);
	public int changePassword(String username, String oldPassword, String newPassword);
	public Account register(String username, String password);
}
