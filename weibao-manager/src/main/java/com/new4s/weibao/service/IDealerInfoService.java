package com.new4s.weibao.service;

import java.util.List;

import com.new4s.weibao.entity.DealerInfo;
import com.new4s.weibao.vo.web.SearchDataVo;

public interface IDealerInfoService {

	List<DealerInfo> selectAll();
	
	DealerInfo selectById(Integer id);
	
	void update(DealerInfo dealerInfo);
	
	void insert(DealerInfo dealerInfo);
	
	void selectDealerList(SearchDataVo vo);
}