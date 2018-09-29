package com.qianfeng.service;

import com.qianfeng.entity.Qiandao;
import com.qianfeng.vo.PageBean;

public interface IQiandaosever {
	
	//添加签到信息的方法
	public void addneewqiandao(Qiandao q,String name);
	
	//查找到签到信息的方法
	public PageBean<Qiandao> findallqiandao(String uname,int page,int limit);
	

}
