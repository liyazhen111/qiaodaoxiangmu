package com.qianfeng.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.entity.Qiandao;
import com.qianfeng.entity.User;
import com.qianfeng.service.IUsereservice;
import com.qianfeng.vo.JsonBean;
import com.qianfeng.vo.PageBean;

@Controller
public class UserController {
	
	@Autowired
	private IUsereservice Usereservice;
	
	//用户登录的方法
	@RequestMapping("/login")
	@ResponseBody
	public JsonBean login(String no, String password, HttpServletRequest request) throws UnsupportedEncodingException{
		//这边会调用realm 得到的数据库的参数  然后再进行比较   在这边比较成功了以后会返回到一个主页面
		UsernamePasswordToken token = new UsernamePasswordToken(no, password);
		// 设置 记住我=true
		
		Subject subject = SecurityUtils.getSubject();

		JsonBean bean = new JsonBean();
		try {
			subject.login(token);
			bean.setCode(1);
			HttpSession session = request.getSession();
			session.setAttribute("username", no);
			//现在写一个可以添加用户登录信息的方法现在在这边拼凑数据
			
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		return bean;
		
	}
	
	
	//用户用于注册的方法
	@RequestMapping("/register")
	@ResponseBody
	public JsonBean userriger(User u) {
		 JsonBean bean = new JsonBean();
		 try {
			Usereservice.adduser(u);
			bean.setCode(1);
			bean.setMsg("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		 
		 return bean;
	}
	
	
	
	//展示一个用户的数据
	@RequestMapping("/zhanshi")
	@ResponseBody
	public Map<String, Object> showallqiandao(int page,int limit,HttpSession session) {
		//现在开始调方法
		String uname =(String) session.getAttribute("username");
		List<User> user = Usereservice.findoneuser(uname);
		
		//创建一个Map对象
		Map<String, Object>map = new HashMap<>();
		map.put("count", 5);
		map.put("code", 0);
		map.put("data",user);
		return map;
	}
	
	//修改账户信息
	@RequestMapping("/updateuser")
	@ResponseBody
	public JsonBean updateuser(User u ,HttpSession session) {
		String uname =(String) session.getAttribute("username");
		 User user = Usereservice.find(uname);
		 Integer id = user.getId();
		 u.setId(id);
		JsonBean bean = new JsonBean();
		try {
			Usereservice.updateuser(u);
			bean.setCode(1);
			bean.setMsg("");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	
	

	
}
