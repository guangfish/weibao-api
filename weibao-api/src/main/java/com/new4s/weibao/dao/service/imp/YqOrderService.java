package com.new4s.weibao.dao.service.imp;

import com.new4s.weibao.dao.entity.YqOrder;
import com.new4s.weibao.dao.mapper.YqOrderMapper;
import com.new4s.weibao.dao.service.IYqOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YqOrderService implements IYqOrderService {
	@Autowired
	private YqOrderMapper yqOrderMapper;

	@Override
	public void insert(YqOrder yqOrder) {
		yqOrderMapper.insert(yqOrder);
	}
}
