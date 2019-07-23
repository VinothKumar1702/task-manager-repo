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

/**
 * The Class TaskEO.
 */
@Entity
@Table(name = "Task")
public class TaskEO {

	/** The task id. */
	@Id
	@Column(name = "Task_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;

	/** The parent task. */
	@ManyToOne
	@JoinColumn(name = "Parent_ID")
	private ParentTaskEO parentTask;

	/** The project. */
	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectEO project;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersEO user;

	/** The priority. */
	@Column(name = "priority")
	private int priority;

	/** The start date. */
	@Column(name = "Start_Date")
	private Date startDate;

	/** The end date. */
	@Column(name = "End_Date")
	private Date endDate;

	/** The task. */
	@Column(name = "Task")
	private String task;

	@Column(name = "Status")
	private String status;

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
	public void setTaskId(final int taskId) {
		this.taskId = taskId;
	}

	/**
	 * Gets the parent task.
	 *
	 * @return the parent task
	 */
	public ParentTaskEO getParentTask() {
		return parentTask;
	}

	/**
	 * Sets the parent task.
	 *
	 * @param parentTask the new parent task
	 */
	public void setParentTask(final ParentTaskEO parentTask) {
		this.parentTask = parentTask;
	}

	public UsersEO getUser() {
		return user;
	}

	public void setUser(UsersEO user) {
		this.user = user;
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
	public void setPriority(final int priority) {
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
	public void setStartDate(final Date startDate) {
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
	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
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
	public void setTask(final String task) {
		this.task = task;
	}

	public ProjectEO getProject() {
		return project;
	}

	public void setProject(ProjectEO project) {
		this.project = project;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
