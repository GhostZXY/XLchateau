package com.hqyj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.bean.Products;
import com.hqyj.bean.Users;
import com.hqyj.service.ProductService;
import com.hqyj.service.UserService;

@Controller
@RequestMapping("/buyer")
public class BuyerController {
	
	@Resource(name="ProductService")
	ProductService productService;
	@Resource(name="UserService")
	UserService userService;
	
	@RequestMapping("/toRegister")
	public String toRegister(){
		return "register";
	}
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "buyerLogin";
	}
	@RequestMapping("/home")
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
	
	@RequestMapping("/register")
	public String register(Users users){
		if(userService.addUser(users)){
			return "buyerLogin";
		}
		return "register";
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public String login(Users users,HttpServletResponse response){
		if(userService.login(users)){
			Cookie cookie = new Cookie("LOGINNAME", users.getU_username());
			response.addCookie(cookie);
			return "success";
		}
		return "failed";
	}
	
	@RequestMapping("/toModify")
	public String toModify(Model model,String loginName){
		model.addAttribute("userInfo",userService.findUserByUsername(loginName));
		return "buyerModify";
	}
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
