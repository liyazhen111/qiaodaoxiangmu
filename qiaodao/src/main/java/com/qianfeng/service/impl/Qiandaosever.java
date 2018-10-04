package com.qianfeng.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.IQiandaoDao;
import com.qianfeng.entity.Qiandao;
import com.qianfeng.service.IQiandaosever;
import com.qianfeng.vo.PageBean;
@Service
public class Qiandaosever implements IQiandaosever {
	@Autowired
	private IQiandaoDao qiandao;

	//添加新的签到信息
	@Override
	public void addneewqiandao(Qiandao q,String name) {
		//首先进行查找
		Date date = q.getBegantime();
		//然后把时间进行格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String format = sdf.format(date);
		String[] split = format.split(" ");
		//因为我们要进行模糊查询所有就要进行时间的切分
		Map map = new HashMap<>();
		map.put("time",split[0] );
		map.put("uname", name);
		List<Qiandao> list = qiandao.selectall(map);
		
		if (list.size()!=0) {
			for (Qiandao aa : list) {
				if (aa.getFlag()<2) {
					String[] split2 = split[1].split(":");
					if(Integer.parseInt(split2[0].trim()) >= 9 &&Integer.parseInt(split2[0].trim())<=21) {
					Map map1 = new HashMap<>();
					map1.put("flag", 2);
					map1.put("id", aa.getId());
					qiandao.updateall(map1);
						q.setFlag(2);
					qiandao.addnewqiandao(q);}
				}
			}
		}else {
			q.setFlag(1);
			qiandao.addnewqiandao(q);
		}
		
		 
		
		
	}

	//展示签到信息
	@Override
	public PageBean<Qiandao> findallqiandao(String uname, int page, int limit) {
		// TODO Auto-generated method stub
		//先来一个对象pagebean
		PageBean<Qiandao> pageinfo = new PageBean<>();
		//再来一个map对象用来传参
		Map map = new HashMap<>();
		page = ((page-1)*limit);
		map.put("limit", limit);
		map.put("page", page);
		map.put("uname", uname);
		List<Qiandao> list = qiandao.showqindao(map);
		int count = qiandao.count(uname);
		pageinfo.setCount(count);
		pageinfo.setPageInfos(list);
		return pageinfo;
	}
	
	
}
