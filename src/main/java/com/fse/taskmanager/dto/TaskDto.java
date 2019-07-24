/*
 * 
 */
package com.fse.taskmanager.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

// TODO: Auto-generated Javadoc
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
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	/** The end date. */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	/** The completed. */
	private String completed;
	
	/** The parent task flag. */
	private boolean parentTaskFlag;
	
	/** The parent id. */
	private int parentId;
	
	/** The parent task. */
	private String parentTask;
	
	/** The project. */
	private String project;
	
	/** The project id. */
	private int projectId;
	
	/** The user. */
	private String user;
	
	/** The user id. */
	private int userId;

	/**
	 * Instantiates a new task dto.
	 */
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

	/**
	 * Gets the parent id.
	 *
	 * @return the parent id
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * Sets the parent id.
	 *
	 * @param parentId the new parent id
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * Gets the parent task.
	 *
	 * @return the parent task
	 */
	public String getParentTask() {
		return parentTask;
	}

	/**
	 * Sets the parent task.
	 *
	 * @param parentTask the new parent task
	 */
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	/**
	 * Checks if is parent task flag.
	 *
	 * @return true, if is parent task flag
	 */
	public boolean isParentTaskFlag() {
		return parentTaskFlag;
	}

	/**
	 * Sets the parent task flag.
	 *
	 * @param parentTaskFlag the new parent task flag
	 */
	public void setParentTaskFlag(boolean parentTaskFlag) {
		this.parentTaskFlag = parentTaskFlag;
	}

	/**
	 * Gets the project.
	 *
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 *
	 * @param project the new project
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * Gets the project id.
	 *
	 * @return the project id
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * Sets the project id.
	 *
	 * @param projectId the new project id
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the completed.
	 *
	 * @return the completed
	 */
	public String getCompleted() {
		return completed;
	}

	/**
	 * Sets the completed.
	 *
	 * @param completed the new completed
	 */
	public void setCompleted(String completed) {
		this.completed = completed;
	}

	
}
