package com.new4s.weibao.entity.vo;

import java.util.List;

import com.new4s.weibao.entity.SysUser;

/**
 * Created by caiting on 2018/1/16.
 */
public class SysUserVo extends SysUser {
    private List<SysMenuVo> menuList;

    public List<SysMenuVo> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenuVo> menuList) {
        this.menuList = menuList;
    }
}
