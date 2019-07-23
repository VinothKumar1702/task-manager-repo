package com.fse.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<TaskDto> viewTask()  {
		final List<TaskDto> viewTaskResponse = taskManagerDomain.viewTask();
		return viewTaskResponse;
	}	
	
	@RequestMapping(value = "/view/{taskId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public TaskDto viewTaskById(@PathVariable int taskId)  {
		final TaskDto viewTaskResponse = taskManagerDomain.viewTaskById(taskId);
		return viewTaskResponse;
	}
	
	@RequestMapping(value = "/view-by-project/{projectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<TaskDto> viewTaskByProject(@PathVariable int projectId)  {
		final List<TaskDto> viewTaskResponse = taskManagerDomain.viewTaskByProject(projectId);
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
	
	
	/**
	 * Delete task.
	 *
	 * @param taskDto the task dto
	 * @return true, if successful
	 */
	@RequestMapping(value = "/end", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public boolean endTask(@RequestParam final int taskId)  {
		final boolean removeTask = taskManagerDomain.endTask(taskId);
		return removeTask;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public TaskDto updateTask(@RequestBody TaskDto task){
		
		return task = taskManagerDomain.updateTask(task);
	}

}
