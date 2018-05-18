package com.new4s.weibao.service;

import java.util.List;

import com.new4s.weibao.entity.Channel;
import com.new4s.weibao.vo.web.SearchDataVo;

public interface IChannelService {

	List<Channel> selectAll();
	
	void insert(Channel channel);
	
	Channel selectByID(Integer channelId);
	
	void update(Channel channel);
	
	void selectChannelList(SearchDataVo vo);
}