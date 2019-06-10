package com.fse.taskmanager.dto;

/**
 * The Class TaskManagerResponseDto.
 */
public class ParentTaskDto{

	/** The parent id. */
	private int parentId;
	
	/** The parent task. */
	private String parentTask;
	
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

	public ParentTaskDto() {
		super();
	}

	
}
