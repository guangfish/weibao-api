package com.new4s.weibao.dao.service.imp;

import com.new4s.weibao.dao.entity.TaskRecord;
import com.new4s.weibao.dao.mapper.TaskRecordMapper;
import com.new4s.weibao.dao.service.ITaskRecordService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskRecordService implements ITaskRecordService {
	@Autowired
	private TaskRecordMapper taskRecordMapper;

	@Override
	public void insert(TaskRecord taskRecord) {
		taskRecordMapper.insert(taskRecord);
	}

	@Override
	public List<TaskRecord> selectByStatus(Integer status) {
		return taskRecordMapper.selectByStatus(status);
	}
	
	@Override
	public void updateByPrimaryKey(TaskRecord taskRecord){
		taskRecordMapper.updateByPrimaryKey(taskRecord);
	}
}
