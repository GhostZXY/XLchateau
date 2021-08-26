package com.hqyj.service;

import java.util.List;

import com.hqyj.bean.Products;

public interface ProductService {
	public List<Products> findAllProduct();
	
	public Products findProductById(int id);
}
