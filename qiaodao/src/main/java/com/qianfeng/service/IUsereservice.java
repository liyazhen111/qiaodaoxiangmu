package com.qianfeng.service;


import java.util.List;

import com.qianfeng.entity.User;
import com.qianfeng.vo.PageBean;

public interface IUsereservice {
	//用户登录的方法
	public User find (String name);
	
	//写一个注册用户的方法
	public void adduser(User u);
	
	//修改用户的方法
	public void updateuser(User u);
	
	//通过名字展示用户信息的方法
	public List<User> findoneuser(String name);
	
	
	
	
	

}
