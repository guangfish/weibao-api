package com.new4s.weibao.dao.mapper;

import java.util.List;

import com.new4s.weibao.dao.entity.Channel;

public interface ChannelMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table channel
	 * @mbg.generated  Fri May 18 09:21:24 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table channel
	 * @mbg.generated  Fri May 18 09:21:24 CST 2018
	 */
	int insert(Channel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table channel
	 * @mbg.generated  Fri May 18 09:21:24 CST 2018
	 */
	int insertSelective(Channel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table channel
	 * @mbg.generated  Fri May 18 09:21:24 CST 2018
	 */
	Channel selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table channel
	 * @mbg.generated  Fri May 18 09:21:24 CST 2018
	 */
	int updateByPrimaryKeySelective(Channel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table channel
	 * @mbg.generated  Fri May 18 09:21:24 CST 2018
	 */
	int updateByPrimaryKey(Channel record);

	List<Channel> selectAll();
}