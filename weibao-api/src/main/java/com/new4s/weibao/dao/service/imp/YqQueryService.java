package com.new4s.weibao.dao.service.imp;
import com.new4s.weibao.dao.entity.YqQueryWithBLOBs;
import com.new4s.weibao.dao.mapper.YqQueryMapper;
import com.new4s.weibao.dao.service.IYqQueryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YqQueryService implements IYqQueryService {
	@Autowired
	private YqQueryMapper yqQueryMapper;

	public YqQueryWithBLOBs selectByVin(String vin){
		return yqQueryMapper.selectByVin(vin);
	}
}
