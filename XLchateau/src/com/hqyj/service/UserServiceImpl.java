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

	@Override
	public Users findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.queryUserById(id);
	}

	@Override
	public boolean addUser(Users users) {
		// TODO Auto-generated method stub
		if(userDao.queryUserByUsername(users.getU_username()) == null){
		return userDao.addUser(users)!=0;
	}
		return false;
	}

	@Override
	public boolean login(Users users) {
		// TODO Auto-generated method stub
		Users u = userDao.queryUserByUsername(users.getU_username());
		if(u != null){
			if(u.getU_password().equals(users.getU_password())){
				return true;
			}
		}
		return false;
	}

	@Override
	public Users findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.queryUserByUsername(username);
	}
	
}
