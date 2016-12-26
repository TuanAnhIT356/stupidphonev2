package com.dhl.blahblah.dao;

import com.dhl.blahblah.model.ProductDetail;

public interface IProductDetailDAO {
	public ProductDetail get(int id);
	public ProductDetail update(ProductDetail productDetail);
}
