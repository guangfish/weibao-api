package com.new4s.weibao.dao.vo;

import java.io.Serializable;

public class TaskVo implements Serializable{
	private static final long serialVersionUID = 4364513886287383714L;
	
	private String vinCode="";
	private String orderTime="";
	public String getVinCode() {
		return vinCode;
	}
	public void setVinCode(String vinCode) {
		this.vinCode = vinCode;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
}
