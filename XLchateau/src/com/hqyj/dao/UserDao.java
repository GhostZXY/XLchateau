package com.hqyj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.bean.Users;

public interface UserDao {
	public List<Users> queryAllUser();
	public Users queryUserById(@Param("id")int id);
	public int addUser(Users users);
	public Users queryUserByUsername(@Param("u_username")String u_username);
}
