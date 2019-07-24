/*
 * 
 */
package com.fse.taskmanager.domain;

import java.util.List;

import com.fse.taskmanager.dto.ParentTaskDto;

// TODO: Auto-generated Javadoc
/**
 * The Interface IParentTaskDomain.
 */
public interface IParentTaskDomain {

	/**
	 * Gets the parent tasks.
	 *
	 * @return the parent tasks
	 */
	List<ParentTaskDto> getParentTasks();

	/**
	 * Gets the parent task by id.
	 *
	 * @param parentTaskId the parent task id
	 * @return the parent task by id
	 */
	ParentTaskDto getParentTaskById(int parentTaskId);

}
