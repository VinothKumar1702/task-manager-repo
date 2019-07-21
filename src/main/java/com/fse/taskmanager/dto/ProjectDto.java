package com.fse.taskmanager.dto;

import java.util.Date;

public class ProjectDto {

	private String project;
	
	private int projectId;
	
	private Date startDate;
	
	private Date endDate;
	
	private int priority;
	
	private String manager;
	
	private int userId;
	
	private int tasks;
	
	private int completed;

	
	public ProjectDto() {
		super();
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
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


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getTasks() {
		return tasks;
	}


	public void setTasks(int tasks) {
		this.tasks = tasks;
	}


	public int getCompleted() {
		return completed;
	}


	public void setCompleted(int completed) {
		this.completed = completed;
	}

	
}
