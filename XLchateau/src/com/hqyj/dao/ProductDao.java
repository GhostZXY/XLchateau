package com.hqyj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.bean.Products;

public interface ProductDao {
	public List<Products> queryAllProduct();
	//@Param("id")和u_id后面的${id}一致
	public Products queryProductById(@Param("id")int id);
}
