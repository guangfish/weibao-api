package com.new4s.weibao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.new4s.weibao.entity.BrandInfo;
import com.new4s.weibao.mapper.BrandInfoMapper;
import com.new4s.weibao.service.IBrandInfoService;

@Service
public class BrandInfoService implements IBrandInfoService {

	@Autowired
	private BrandInfoMapper brandInfoMapper;

	@Override
	public List<BrandInfo> selectAll() {
		return brandInfoMapper.selectAll();
	}
}