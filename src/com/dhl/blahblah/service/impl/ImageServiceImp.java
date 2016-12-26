package com.dhl.blahblah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhl.blahblah.dao.IImageDAO;
import com.dhl.blahblah.model.Image;
import com.dhl.blahblah.service.IImageService;

@Service
public class ImageServiceImp implements IImageService {

	@Autowired
	IImageDAO imageDAO;
	
	@Override
	@Transactional
	public Image getImageByProductId(int productId, String type) {
		return imageDAO.getImageByProductId(productId, type);
	}

	@Override
	@Transactional
	public void insert(Image image) {
		if(!image.getType().equals("other"))
			imageDAO.delete(image.getProduct().getId(), image.getType());
		imageDAO.insert(image);
	}

	@Override
	@Transactional
	public List<Image> getImageByProductId(int productId) {
		return imageDAO.getImageByProductId(productId);
	}
}
