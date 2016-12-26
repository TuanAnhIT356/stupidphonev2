package com.dhl.blahblah.service;

import com.dhl.blahblah.model.ProductDetail;

public interface IProductDetailService {
	public ProductDetail get(int id);
	public ProductDetail update(ProductDetail productDetail);
}
