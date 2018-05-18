package com.new4s.weibao.web.controller.vo;

import java.io.Serializable;
import java.util.List;

public class JsonResult implements Serializable {
	private static final long serialVersionUID = 3159905137691700698L;
	private List<?> rows;
	private String total;

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
    
}
