package com.qianfeng.realm;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.qianfeng.dao.IUserDao;

import com.qianfeng.entity.User;



public class MyRealm extends AuthorizingRealm{
	@Autowired
	private IUserDao dao;
	
	

	//在这边得到的前端传来的验证数据然后在数据库进行查询   然后查到数据   然后将数据返回到login  然后进行比较   在这边还会的到验证信息还会得到权限信息都存放在falm里面
	//因为有配置文件   就会在realm里面  就算调用也是  内部调用  这个就相当于一个域对象  在这边 得到数据之后  然后 进行  数据存放  后来会用到
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
		
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String name = (String)token.getPrincipal();
		
		// 从数据库中根据用户名获取密码信息
		User user = dao.find(name);
		if(user == null){
			throw new UnknownAccountException();
		}
		String password = user.getPassword();
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(name, password, this.getName());
		
		return info;
		
	}

}
