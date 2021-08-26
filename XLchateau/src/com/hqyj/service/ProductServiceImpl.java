package com.hqyj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hqyj.bean.Products;
import com.hqyj.dao.ProductDao;

@Service(value="ProductService")
public class ProductServiceImpl implements ProductService {
	@Resource
	ProductDao productDao;
	
	
	public ProductDao getProductDao() {
		return productDao;
	}

	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	@Override
	public List<Products> findAllProduct() {
		// TODO Auto-generated method stub
		return productDao.queryAllProduct();
	}


	@Override
	public Products findProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.queryProductById(id);
	}

}
