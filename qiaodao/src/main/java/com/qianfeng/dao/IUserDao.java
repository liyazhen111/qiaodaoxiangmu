package com.qianfeng.dao;

import java.util.List;
import java.util.Map;

import com.qianfeng.entity.User;

public interface IUserDao {
	//先写一个注册用户的方法
	public void add (User user);
	
	//用户用于登录的方法
	public User find (String name);
	
	//修改用户资料的方法
	public void updateuser(User u);
	
	//展示用户信息的方法分页展示
	public List <User> showuser(String name);
	
	
	
}
