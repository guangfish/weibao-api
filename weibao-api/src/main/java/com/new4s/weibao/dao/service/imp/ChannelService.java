package com.new4s.weibao.dao.service.imp;

import com.new4s.weibao.dao.entity.Channel;
import com.new4s.weibao.dao.mapper.ChannelMapper;
import com.new4s.weibao.dao.service.IChannelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelService implements IChannelService {
	@Autowired
	private ChannelMapper channelMapper;

	@Override
	public Channel select(Integer id) {
		return channelMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Channel> selectAll(){
		return channelMapper.selectAll();
	}
}
