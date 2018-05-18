package com.new4s.weibao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.new4s.weibao.entity.Channel;
import com.new4s.weibao.entity.YqOrderVo;
import com.new4s.weibao.mapper.ChannelMapper;
import com.new4s.weibao.service.IChannelService;
import com.new4s.weibao.vo.web.SearchDataVo;

@Service
public class ChannelService implements IChannelService {

	@Autowired
	private ChannelMapper channelMapper;

	@Override
	public List<Channel> selectAll() {
		return channelMapper.selectAll();
	}

	@Override
	public void insert(Channel channel) {
		channelMapper.insert(channel);
	}
	
	@Override
	public Channel selectByID(Integer channelId){
		return channelMapper.selectByPrimaryKey(channelId);
	}
	
	@Override
	public void update(Channel channel) {
		channelMapper.updateByPrimaryKey(channel);
	}
	
	@Override
	public void selectChannelList(SearchDataVo vo){
		int count = channelMapper.selectChannelCount(vo.getSearchMap());
		vo.setCount(count);
		if (count > 0) {
			vo.setList(channelMapper.selectChannelList(vo.getSearchMap(), new RowBounds(vo.getStart(), vo.getSize())));
		} else {
			vo.setList(new ArrayList<Channel>());
		}
		
	}
}