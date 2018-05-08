package com.new4s.weibao.dao.mapper;

import java.util.List;

import com.new4s.weibao.dao.entity.TaskRecord;

public interface TaskRecordMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task_record
	 * @mbg.generated  Tue May 08 11:31:15 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task_record
	 * @mbg.generated  Tue May 08 11:31:15 CST 2018
	 */
	int insert(TaskRecord record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task_record
	 * @mbg.generated  Tue May 08 11:31:15 CST 2018
	 */
	int insertSelective(TaskRecord record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task_record
	 * @mbg.generated  Tue May 08 11:31:15 CST 2018
	 */
	TaskRecord selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task_record
	 * @mbg.generated  Tue May 08 11:31:15 CST 2018
	 */
	int updateByPrimaryKeySelective(TaskRecord record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task_record
	 * @mbg.generated  Tue May 08 11:31:15 CST 2018
	 */
	int updateByPrimaryKey(TaskRecord record);

	List<TaskRecord> selectByStatus(Integer status);
}