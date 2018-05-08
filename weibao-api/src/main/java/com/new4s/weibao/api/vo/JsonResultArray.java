package com.new4s.weibao.api.vo;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by caiting on 2017/9/29.
 */
public class JsonResultArray implements Serializable {

	private static final long serialVersionUID = -8600457238901336703L;

	public Collection<? extends Serializable> getList() {
        return list;
    }

    public void setList(Collection<? extends Serializable> list) {
        this.list = list;
    }

    private Collection<? extends Serializable> list;
}
