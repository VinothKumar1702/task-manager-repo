package com.fse.taskmanager.dto;

import java.util.Date;

public class TaskDto {

	/** The task. */
	private String task;
	
	private int taskId;
	
	/** The priority. */
	private int priority;
	
	/** The start date. */
	private Date startDate;
	
	/** The end date. */
	private Date endDate;

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
