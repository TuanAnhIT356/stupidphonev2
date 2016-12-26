package com.dhl.blahblah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhl.blahblah.dao.IAccountDAO;
import com.dhl.blahblah.dao.ICartDAO;
import com.dhl.blahblah.dao.IProductDAO;
import com.dhl.blahblah.dao.ITestDAO;
import com.dhl.blahblah.model.Account;
import com.dhl.blahblah.service.ITestService;

@Service
public class TestServiceImpl implements ITestService{
	@Autowired
	ITestDAO testDAO;
	
	@Autowired
	IAccountDAO accountDAO;
	
	@Autowired
	IProductDAO productDAO;
	
	@Autowired
	ICartDAO cartDAO;
	
	@Transactional
	public void test(){
		Account account = accountDAO.register("test1","newdawn1402");
		System.out.println(account);
	}
}
