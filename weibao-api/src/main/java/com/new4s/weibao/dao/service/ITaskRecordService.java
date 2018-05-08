package com.new4s.weibao.dao.service;

import java.util.List;

import com.new4s.weibao.dao.entity.TaskRecord;

public interface ITaskRecordService {
	public void insert(TaskRecord taskRecord);
	public List<TaskRecord> selectByStatus(Integer status);	
	public void updateByPrimaryKey(TaskRecord taskRecord);

}
