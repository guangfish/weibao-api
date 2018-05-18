package com.new4s.weibao.dao.service;

import java.util.List;

import com.new4s.weibao.dao.entity.Channel;

public interface IChannelService {
	public Channel select(Integer id);
	
	public List<Channel> selectAll();
}
