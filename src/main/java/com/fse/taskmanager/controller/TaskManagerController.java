package com.fse.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fse.taskmanager.domain.ITaskManagerDomain;
import com.fse.taskmanager.dto.TaskDto;

/**
 * The Class TaskManagerController.
 */
@RestController
@RequestMapping("/task")
public class TaskManagerController {

	/** The task manager domain. */
	@Autowired
	private ITaskManagerDomain taskManagerDomain;
	
	/**
	 * View task.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<TaskDto> viewTask()  {
		final List<TaskDto> viewTaskResponse = taskManagerDomain.viewTask();
		return viewTaskResponse;
	}	
	
	/**
	 * Adds the task.
	 *
	 * @param taskDto the task dto 
	 * @return the task dto
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public TaskDto addTask(@RequestBody final TaskDto taskDto)  {
		final TaskDto addTask = taskManagerDomain.addTask(taskDto);
		return addTask;
	}
	
}
