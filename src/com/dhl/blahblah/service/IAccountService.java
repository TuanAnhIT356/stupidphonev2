package com.dhl.blahblah.service;

import com.dhl.blahblah.model.Account;

public interface IAccountService {
	public Account login(String username, String password);
	public int changePassword(String username, String oldPassword, String newPassword);
	public Account register(String username, String password);
}
