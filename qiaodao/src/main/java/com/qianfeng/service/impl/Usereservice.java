package com.qianfeng.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.RemoteTimeoutException;
import org.springframework.stereotype.Service;


import com.qianfeng.dao.IUserDao;
import com.qianfeng.entity.User;
import com.qianfeng.service.IUsereservice;
import com.qianfeng.vo.PageBean;
@Service
public class Usereservice implements IUsereservice {
	@Autowired
	private IUserDao dao;
	
	@Override
	public User find(String name) {
		// TODO Auto-generated method stub
		User list = dao.find(name);
		return list;
	}

	@Override
	public void adduser(User u) {
		// TODO Auto-generated method stub
		try {
			dao.add(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//修改用户信息的方法
	@Override
	public void updateuser(User u) {
		// TODO Auto-generated method stub
		try {
			dao.updateuser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//通过名字找到用户进行展示
	@Override
	public List< User> findoneuser(String name) {
		// TODO Auto-generated method stub
		 List<User> list = dao.showuser(name);
		return list;
	}
	
}
