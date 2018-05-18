package com.new4s.weibao.api.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.new4s.weibao.dao.entity.Channel;
import com.new4s.weibao.dao.service.IChannelService;

/**
 * Created by chenhj on 2017/9/28.
 */
@Service
public class GlobalVariable {
	Logger logger = LoggerFactory.getLogger(GlobalVariable.class);

	@Autowired
	IChannelService channelService;

	public static Map<String, String> channelMap;

	public void init() {
		logger.info("初始化全局变量开始！~~~~~~~~~~~~~~~");
		// 这里可以做初始化操作
		loadChannels();
		logger.info("初始化全局变量完成！~~~~~~~~~~~~~~~");
	}

	public void loadChannels() {
		List<Channel> channelList = channelService.selectAll();
		if (channelList != null && channelList.size() > 0) {
//			logger.info(channelList.size()+"");
			channelMap = new HashMap<>();
			for (Channel channel : channelList) {
				channelMap.put(String.valueOf(channel.getId()), channel.getAppsecret());
			}
			logger.info("渠道初始化完成，共"+channelMap.size()+"个");
		}
	}
}
