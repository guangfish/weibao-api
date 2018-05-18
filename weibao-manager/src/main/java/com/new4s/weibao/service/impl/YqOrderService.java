package com.new4s.weibao.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.new4s.weibao.entity.YqOrderVo;
import com.new4s.weibao.mapper.YqOrderMapper;
import com.new4s.weibao.service.IYqOrderService;
import com.new4s.weibao.vo.web.SearchDataVo;

@Service
public class YqOrderService implements IYqOrderService {

	@Autowired
	private YqOrderMapper yqOrderMapper;

	@Override
	public String getStatsRecord() {
		return yqOrderMapper.getStatsRecord();
	}

	@Override
	public List<YqOrderVo> getStatsRecordList(Map<String, Object> searchMap) {
		return yqOrderMapper.getStatsRecordList(searchMap);
	}

	@Override
	public void getStatsRecordList(SearchDataVo vo) {
		int count = yqOrderMapper.getStatsRecordCount(vo.getSearchMap());
		vo.setCount(count);
		if (count > 0) {
			vo.setList(yqOrderMapper.getStatsRecordList(vo.getSearchMap(), new RowBounds(vo.getStart(), vo.getSize())));
		} else {
			vo.setList(new ArrayList<YqOrderVo>());
		}
	}

	@Override
	public List<YqOrderVo> getYqOrderList(Map<String, Object> searchMap) {
		return yqOrderMapper.getYqOrderList(searchMap);
	}

	@Override
	public void getYqOrderList(SearchDataVo vo) {
		int count = yqOrderMapper.getYqOrderCount(vo.getSearchMap());
		vo.setCount(count);
		if (count > 0) {
			vo.setList(yqOrderMapper.getYqOrderList(vo.getSearchMap(), new RowBounds(vo.getStart(), vo.getSize())));
		} else {
			vo.setList(new ArrayList<YqOrderVo>());
		}
	}
}