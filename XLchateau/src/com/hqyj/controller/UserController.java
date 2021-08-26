package com.hqyj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.bean.Users;
import com.hqyj.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Resource(name="UserService")
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//给S前台传值
	@RequestMapping("/home")
	public String home(Model model){
		List<Users> userList=userService.findAllUser();
		model.addAttribute("userList",userList);
		return "home";
	}
}
