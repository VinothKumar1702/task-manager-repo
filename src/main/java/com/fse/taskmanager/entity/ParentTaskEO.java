package com.fse.taskmanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class ParentTaskEO.
 */
@Entity
@Table(name = "parent")
public class ParentTaskEO {
	
	/** The parent id. */
	@Id
	@Column(name = "Parent_ID",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parentId;
	
	/** The parent task. */
	@Column(name = "Parent_Task")
	private String parentTask;
	
	/** The task list. */
	@OneToMany(mappedBy = "parentTask", cascade = CascadeType.ALL)
	private List<TaskEO> taskList;

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
	public void setParentId(final int parentId) {
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
	public void setParentTask(final String parentTask) {
		this.parentTask = parentTask;
	}

	/**
	 * Gets the task list.
	 *
	 * @return the task list
	 */
	public List<TaskEO> getTaskList() {
		return taskList;
	}

	/**
	 * Sets the task list.
	 *
	 * @param taskList the new task list
	 */
	public void setTaskList(final List<TaskEO> taskList) {
		this.taskList = taskList;
	}
	
	
}
