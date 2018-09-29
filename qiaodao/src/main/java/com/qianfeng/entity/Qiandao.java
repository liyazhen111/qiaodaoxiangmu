package com.qianfeng.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Qiandao {
	private Integer id;
	private Date begantime;
	private String uname;
	private Integer flag;
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
	public Date getBegantime() {
		return begantime;
	}
	public void setBegantime(Date begantime) {
		this.begantime = begantime;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}

}
