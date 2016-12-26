package com.dhl.blahblah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dhl.blahblah.dao.ICartDetailDAO;
import com.dhl.blahblah.service.ICartDetailService;

public class CartDetailServiceImpl implements ICartDetailService {

	@Autowired
	ICartDetailDAO cartDetailDAO;
	
	@Override
	@Transactional
	public void delete(int cartId) {
		cartDetailDAO.delete(cartId);
	}
}
