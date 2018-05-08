package com.new4s.weibao.service;

import java.util.List;

import com.new4s.weibao.entity.vo.SysMenuVo;

/**
 *
 * SysMenu表数据服务层接口
 *
 */
public interface ISysMenuService {

	List<SysMenuVo> findMenuListByUsername(String username);
}