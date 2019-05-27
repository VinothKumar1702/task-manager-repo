package com.fse.taskmanager.domain;

import java.util.List;

import com.fse.taskmanager.dto.TaskDto;

/**
 * The Interface ITaskManagerDomain.
 */
public interface ITaskManagerDomain {

	/**
	 * View task.
	 *
	 * @return the list
	 */
	List<TaskDto> viewTask();

	/**
	 * Adds the task.
	 *
	 * @param taskDto the task dto
	 * @return the task dto
	 */
	TaskDto addTask(TaskDto taskDto);

	/**
	 * Delete task.
	 *
	 * @param taskDto the task dto
	 * @return true, if successful
	 */
	boolean deleteTask(TaskDto taskDto);

}
