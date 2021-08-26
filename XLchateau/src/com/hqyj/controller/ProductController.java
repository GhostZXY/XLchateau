package com.hqyj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.bean.Products;
import com.hqyj.bean.Users;
import com.hqyj.service.ProductService;
import com.hqyj.service.UserService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Resource(name="ProductService")
	ProductService productService;
	
	
	public ProductService getProductService() {
		return productService;
	}


	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	//给S前台传值
	@RequestMapping("/buyer")
	public String home(Model model){
		List<Products> productList=productService.findAllProduct();
		model.addAttribute("productList",productList);
		return "buyer";
	}
	
	@RequestMapping("/info")
	public String info(Model model,int id){
		model.addAttribute("productsInfo",productService.findProductById(id));
		return "productInfo";
	}
}
