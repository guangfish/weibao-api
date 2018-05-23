package com.new4s.weibao.web.component;


import com.new4s.weibao.entity.vo.*;
import com.new4s.weibao.enums.*;
import com.new4s.weibao.security.ShiroUtils;
import com.new4s.weibao.util.ConfigUtil;
import com.new4s.weibao.util.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * 
 * @author hl-tanyong
 * @version $Id: VMComponent.java, v 0.1 2015年9月29日 上午11:33:12 hl-tanyong Exp $
 */
@Component
public class VMComponent {

	protected final Logger logger = LoggerFactory.getLogger(VMComponent.class);


	public String getEvnVariable() {
		return ConfigUtil.getString("is_test_evn", "off");
	}

	@SuppressWarnings("unchecked")
	public List<SysMenuVo> getMenuList() {
		Object menuList = ShiroUtils.getSessionAttribute(SessionKey.SESSION_USER_MENU.toString());
		if (menuList == null) {
			return new ArrayList<SysMenuVo>();
		} else {
			return (List<SysMenuVo>) menuList;
		}
	}

	public String getLoginUserName() {
		Object userObj = ShiroUtils.getSessionAttribute(SessionKey.SESSION_LOGIN_USER.toString());
		if (userObj != null) {
			SysUserVo userInfo = (SysUserVo) userObj;
			return userInfo.getRealname();
		}
		return "";
	}

	/**
	 * 得到一个删除其中几个参数的URL
	 * 
	 * @param url
	 * @param keys
	 * @return
	 */
	public String getUrlByRemoveKey(String url, String[] keys) {
		String qs = StringUtil.findStr(url, "?", null);
		HashMap<String, String> map = getParams(qs);
		if (map.size() > 0) {
			for (String key : keys) {
				map.remove(key);
			}
			StringBuilder sb = new StringBuilder();
			sb.append(StringUtil.findStr(url, null, "?"));
			if (map.size() > 0) {
				sb.append("?");
				int i = 0;
				for (Entry<String, String> kv : map.entrySet()) {
					if (i > 0) {
						sb.append("&");
					}
					sb.append(kv.getKey());
					sb.append("=");
					sb.append(StringUtil.urlencoder(kv.getValue()));
					i++;
				}
			}
			return sb.toString();
		}
		return url;
	}

	/**
	 * 获取广告活动状态文字（带颜色）
	 * */
	public String getActivityStatusTextWithColor(int id){
		String color = "";
		if(id==ActivityStatus.UNCONFIRM.getId()){
			color = "style='color:red;'";
		}else if(id==ActivityStatus.COMPLETE.getId()){
			color = "style='color:green;'";
		}
		return "<span "+color+" >"+ActivityStatus.getText(id)+"</span>";
	}
	/**
	 * 获取广告活动状态文字
	 * */
	public String getActivityStatusText(int id){
		return ActivityStatus.getText(id);
	}
	/**
	 * 获取广告活动状态列表
	 * */
	public ActivityStatus[] getActivityStatusList(){
		return ActivityStatus.values();
	}
	/**
	 * 获取广告活动监测任务状态文字
	 * */
	public String getMonitorTaskStatusText(int id){
		return MonitorTaskStatus.getText(id);
	}
	/**
	 * 获取广告活动监测任务状态列表
	 * */
	public MonitorTaskStatus[] getMonitorTaskStatusList(){
		return MonitorTaskStatus.values();
	}
	/**
	 * 获取广告活动监测任务类型文字
	 * */
	public String getMonitorTaskTypeText(int id){
		return MonitorTaskType.getText(id);
	}
	/**
	 * 获取广告活动纠错任务状态文字
	 * */
	public String getJiucuoTaskStatusText(int id){
		return JiucuoTaskStatus.getText(id);
	}
	/**
	 * 获取广告活动纠错任务状态列表
	 * */
	public JiucuoTaskStatus[] getJiucuoTaskStatusList(){
		return JiucuoTaskStatus.values();
	}

	/***************************** 下面是工具类 ****************************************/
	private HashMap<String, String> getParams(String qs) {
		HashMap<String, String> params = new HashMap<String, String>();
		if (qs != null) {
			String[] keyValue = qs.split("&");
			for (String kv : keyValue) {
				int offset = kv.indexOf("=");
				if ((offset > 0) && (offset < (kv.length() - 1))) {
					params.put(kv.substring(0, offset), kv.substring(offset + 1));
				}
			}
		}
		return params;
	}

}