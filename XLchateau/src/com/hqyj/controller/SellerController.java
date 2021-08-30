package com.hqyj.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.bean.Users;
import com.hqyj.service.UserService;

@Controller
@RequestMapping("/seller")
public class SellerController {

	@Resource(name = "UserService")
	UserService userService;
	
	@RequestMapping("/toLogin")
	public String toSellerLogin(){
		return "sellerLogin";
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public String sellerLogin(Users users,HttpServletResponse response){
		if(userService.login(users)){
			Users u = userService.findUserByUsername(users.getU_username());
			if(u.getU_hasstore().equals("1")){
				response.addCookie(new Cookie("HASSTORE","true"));
			}else{
				response.addCookie(new Cookie("HASSTORE", "false"));
			}
			return "success";
		}
		return "failed";
	}
	
	
	@RequestMapping("/home")
	public String home(){
		return "sellerHome";
	}
	
	@RequestMapping("/toAddStore")
	public String toAddStore(){
		return "addStore";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
