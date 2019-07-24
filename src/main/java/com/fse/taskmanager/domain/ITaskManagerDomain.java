/*
 * 
 */
package com.fse.taskmanager.domain;

import java.util.List;

import com.fse.taskmanager.dto.TaskDto;

// TODO: Auto-generated Javadoc
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
	 * @param taskId the task dto
	 * @return true, if successful
	 */
	boolean endTask(int taskId);

	/**
	 * Update task.
	 *
	 * @param task the task
	 * @return the task dto
	 */
	TaskDto updateTask(TaskDto task);

	/**
	 * View task by id.
	 *
	 * @param taskId the task id
	 * @return the task dto
	 */
	TaskDto viewTaskById(int taskId);

	/**
	 * View task by project.
	 *
	 * @param projectId the project id
	 * @return the list
	 */
	List<TaskDto> viewTaskByProject(int projectId);
 }
