package com.dhl.blahblah.service;

import java.util.List;

import com.dhl.blahblah.model.Image;

public interface IImageService {
	public Image getImageByProductId(int productId, String type);
	public List<Image> getImageByProductId(int productId);
	public void insert(Image image);
}
