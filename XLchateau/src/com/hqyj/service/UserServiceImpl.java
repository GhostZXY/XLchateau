package com.hqyj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hqyj.bean.Users;
import com.hqyj.dao.UserDao;

@Service(value="UserService")
public class UserServiceImpl implements UserService{
	@Resource
	UserDao userDao;

	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<Users> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.queryAllUser();
	}
	
	
}
