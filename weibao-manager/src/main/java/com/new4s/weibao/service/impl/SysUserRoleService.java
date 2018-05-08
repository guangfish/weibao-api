package com.new4s.weibao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.new4s.weibao.entity.SysUserRole;
import com.new4s.weibao.mapper.SysUserRoleMapper;
import com.new4s.weibao.service.ISysUserRoleService;

@Service
public class SysUserRoleService implements ISysUserRoleService {
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public void insert(SysUserRole sysUserRole) {
		sysUserRoleMapper.insert(sysUserRole);
	}
}
