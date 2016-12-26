package com.dhl.blahblah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhl.blahblah.dao.IProducerDAO;
import com.dhl.blahblah.model.Producer;
import com.dhl.blahblah.service.IProducerService;

@Service
public class ProducerServiceImpl implements IProducerService {

	@Autowired
	IProducerDAO producerDAO;
	
	@Override
	@Transactional
	public List<Producer> getAll() {
		return producerDAO.getAll();
	}

}
