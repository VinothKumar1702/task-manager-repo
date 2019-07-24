/*
 * 
 */
package com.fse.taskmanager.dto;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectDto.
 */
public class ProjectDto {

	/** The project. */
	private String project;
	
	/** The project id. */
	private int projectId;
	
	/** The start date. */
	private Date startDate;
	
	/** The end date. */
	private Date endDate;
	
	/** The priority. */
	private int priority;
	
	/** The manager. */
	private String manager;
	
	/** The user id. */
	private int userId;
	
	/** The tasks. */
	private int tasks;
	
	/** The completed. */
	private int completed;

	
	/**
	 * Instantiates a new project dto.
	 */
	public ProjectDto() {
		super();
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
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}


	/**
	 * Sets the manager.
	 *
	 * @param manager the new manager
	 */
	public void setManager(String manager) {
		this.manager = manager;
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
	 * Gets the tasks.
	 *
	 * @return the tasks
	 */
	public int getTasks() {
		return tasks;
	}


	/**
	 * Sets the tasks.
	 *
	 * @param tasks the new tasks
	 */
	public void setTasks(int tasks) {
		this.tasks = tasks;
	}


	/**
	 * Gets the completed.
	 *
	 * @return the completed
	 */
	public int getCompleted() {
		return completed;
	}


	/**
	 * Sets the completed.
	 *
	 * @param completed the new completed
	 */
	public void setCompleted(int completed) {
		this.completed = completed;
	}

	
}
