package com.fse.taskmanager.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class TaskDto.
 */
public class TaskDto {

	/** The task. */
	private String task;
	
	/** The task id. */
	private int taskId;
	
	/** The priority. */
	private int priority;
	
	/** The start date. */
	private Date startDate;
	
	/** The end date. */
	private Date endDate;
	
	private boolean parentTaskFlag;
	
	/** The parent task. */
	//private ParentTaskDto parentTask;
	
	/** The parent id. */
	private int parentId;
	
	/** The parent task. */
	private String parentTask;

	public TaskDto() {
		super();
	}

	/**
	 * Gets the task.
	 *
	 * @return the task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * Sets the task.
	 *
	 * @param task the new task
	 */
	public void setTask(String task) {
		this.task = task;
	}

	/**
	 * Gets the task id.
	 *
	 * @return the task id
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * Sets the task id.
	 *
	 * @param taskId the new task id
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 *
	 * @param priority the new priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

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

	public boolean isParentTaskFlag() {
		return parentTaskFlag;
	}

	public void setParentTaskFlag(boolean parentTaskFlag) {
		this.parentTaskFlag = parentTaskFlag;
	}

	

	
}
