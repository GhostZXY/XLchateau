package com.hqyj.service;

import java.util.List;

import com.hqyj.bean.Users;

public interface UserService {
	public List<Users> findAllUser();
	public Users findUserById(int id);
	public boolean addUser(Users users);
	public boolean login(Users users);
	public Users findUserByUsername(String username);
}
