package com.new4s.weibao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.new4s.weibao.entity.DealerInfo;
import com.new4s.weibao.mapper.DealerInfoMapper;
import com.new4s.weibao.service.IDealerInfoService;
import com.new4s.weibao.vo.web.SearchDataVo;

@Service
public class DealerInfoService implements IDealerInfoService {

	@Autowired
	private DealerInfoMapper dealerInfoMapper;

	@Override
	public List<DealerInfo> selectAll() {
		return dealerInfoMapper.selectAll();
	}
	
	@Override
	public DealerInfo selectById(Integer id){
		return dealerInfoMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public void insert(DealerInfo dealerInfo){
		dealerInfoMapper.insert(dealerInfo);
	}
	
	@Override
	public void update(DealerInfo dealerInfo){
		dealerInfoMapper.updateByPrimaryKey(dealerInfo);
	}
	
	@Override
	public void selectDealerList(SearchDataVo vo){
		int count = dealerInfoMapper.selectDealerCount(vo.getSearchMap());
		vo.setCount(count);
		if (count > 0) {
			vo.setList(dealerInfoMapper.selectDealerList(vo.getSearchMap(), new RowBounds(vo.getStart(), vo.getSize())));
		} else {
			vo.setList(new ArrayList<DealerInfo>());
		}
	}
}