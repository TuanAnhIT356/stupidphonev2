package com.dhl.blahblah.dao;

import java.util.List;

import com.dhl.blahblah.model.Image;

public interface IImageDAO {
	public Image getImageByProductId(int productId, String type);
	public List<Image> getImageByProductId(int productId);
	public void insert(Image image);
	public void delete(int productId, String type);
}
