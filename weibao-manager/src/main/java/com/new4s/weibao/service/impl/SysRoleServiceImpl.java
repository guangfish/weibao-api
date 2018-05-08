package com.new4s.weibao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.new4s.weibao.entity.vo.SysRoleVo;
import com.new4s.weibao.mapper.SysRoleMapper;
import com.new4s.weibao.service.ISysRoleService;

/**
 * 
 * 
 * @author tanyong
 * @version $Id: SysRoleService.java, v 0.1 2016年12月2日 下午2:36:01 tanyong Exp $
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	/*
	 * (non-Javadoc)
	 * @see com.new4s.weibao.service.ISysRoleService#getRoleListByUserId(java.lang.Integer)
	 */
	@Override
	public List<SysRoleVo> findRoleByUserId(Integer userId) {		
		return sysRoleMapper.findRoleByUserId(userId);
	}
}