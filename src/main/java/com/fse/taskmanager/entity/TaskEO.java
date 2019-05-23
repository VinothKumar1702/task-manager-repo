package com.fse.taskmanager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Task")
public class TaskEO {
	
	@Id
	@Column(name = "Task_ID",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	
	@ManyToOne
	@JoinColumn(name = "Parent_ID")
	private ParentTaskEO parentTask;
	
	@Column(name = "Parent_Task")
	private int priority;
	
	@Column(name = "Start_Date")
	private Date startDate;
	
	@Column(name = "End_Date")
	private Date endDate;
	
	@Column(name = "Task")
	private String task;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public ParentTaskEO getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTaskEO parentTask) {
		this.parentTask = parentTask;
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

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	
}
