package com.new4s.weibao.service;

import java.util.List;
import java.util.Map;

import com.new4s.weibao.entity.YqOrderVo;
import com.new4s.weibao.vo.web.SearchDataVo;

public interface IYqOrderService {

	String getStatsRecord();
	
	List<YqOrderVo> getStatsRecordList(Map<String, Object> searchMap);
	
	void getStatsRecordList(SearchDataVo vo);
	
	List<YqOrderVo> getYqOrderList(Map<String, Object> searchMap);
	
	void getYqOrderList(SearchDataVo vo);
}