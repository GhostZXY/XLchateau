package com.hqyj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.bean.Products;

public interface ProductDao {
	public List<Products> queryAllProduct();
	//@Param("id")��u_id�����${id}һ��
	public Products queryProductById(@Param("id")int id);
}
