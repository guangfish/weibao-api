package com.new4s.weibao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.new4s.weibao.entity.District;
import com.new4s.weibao.mapper.DistrictMapper;
import com.new4s.weibao.service.IDistrictService;

@Service
public class DistrictService implements IDistrictService {

	@Autowired
	private DistrictMapper districtMapper;

	@Override
	public List<District> selectByLevel(Map<String, Object> searchMap) {
		return districtMapper.selectByLevel(searchMap);
	}
}