package com.qianfeng.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.entity.Qiandao;
import com.qianfeng.service.IQiandaosever;
import com.qianfeng.vo.PageBean;

@Controller
class IQiandaoConorller {
	
	@Autowired
	private IQiandaosever Qiandaosever;
	@RequestMapping("/tianjiaqiandao")
	public String tianjiaqiandao(HttpSession session) {
		String name =(String) session.getAttribute("username");
		//现在要获取当前时间
		Date date = new Date();
		Qiandao q= new Qiandao();
		q.setBegantime(date);
		q.setUname(name);
		System.out.println("我改了这边");
		 try {
			Qiandaosever.addneewqiandao(q , name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/qiandaolimit.html";
	}
	//在这边获得行的签到信息进行添加
	
	@RequestMapping("/listhhhhh")
	@ResponseBody
	//展示所有的签到信息的方法
	public Map<String, Object> showallqiandao(int page,int limit,HttpSession session) {
		//现在开始调方法
		String uname =(String) session.getAttribute("username");
		PageBean<Qiandao> pageinfo = Qiandaosever.findallqiandao(uname, page, limit);
		//创建一个Map对象
		Map<String, Object>map = new HashMap<>();
		map.put("code", 0);
		map.put("count", pageinfo.getCount());
		map.put("data", pageinfo.getPageInfos());
		return map;
	}
	

}
