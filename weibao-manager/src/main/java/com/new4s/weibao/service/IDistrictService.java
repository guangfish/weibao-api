package com.new4s.weibao.service;

import java.util.List;
import java.util.Map;

import com.new4s.weibao.entity.District;

public interface IDistrictService {

	List<District> selectByLevel(Map<String, Object> searchMap);
}