package com.fse.taskmanager.dto;

import java.util.Date;
import java.util.List;
/**
 * The Class TaskManagerResponseDto.
 */
public class TaskManagerResponseDto{

	private int parentId;
	
	/** The parent task. */
	private String parentTask;
	
	private List<TaskDto> taskDto;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public List<TaskDto> getTaskDto() {
		return taskDto;
	}

	public void setTaskDto(List<TaskDto> taskDtoList) {
		this.taskDto = taskDtoList;
	}

	
}
