package com.qianfeng.dao;

import java.util.List;
import java.util.Map;

import com.qianfeng.entity.Qiandao;

public interface IQiandaoDao {
	
	//添加签到数据
	public void addnewqiandao(Qiandao q);
	
	//通过名字查找到所有的签到信息现在还需要分页进行查询
	public List<Qiandao> showqindao (Map<String,Object>map);
	
	//进行分页查询的总条数
	public int count (String uname);
	
	//通过时间进行模糊查询的方法
	public List<Qiandao> selectall(Map<String, Object>map);
	
	//修改flag的方法
	public void updateall(Map<String, Object> map);
	
	

}
