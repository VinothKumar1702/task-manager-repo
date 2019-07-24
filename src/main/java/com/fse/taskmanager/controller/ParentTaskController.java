/*
 * 
 */
package com.fse.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fse.taskmanager.domain.IParentTaskDomain;
import com.fse.taskmanager.dto.ParentTaskDto;


// TODO: Auto-generated Javadoc
/**
 * The Class ParentTaskController.
 */
@RestController
@RequestMapping("/parent-task")
public class ParentTaskController {

	
	/** The parent task domain. */
	@Autowired
	private IParentTaskDomain parentTaskDomain;
	
	/**
	 * Gets the parent tasks.
	 *
	 * @return the parent tasks
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ParentTaskDto> getParentTasks() {
		return parentTaskDomain.getParentTasks();
	}
	
	/**
	 * Gets the parent task by id.
	 *
	 * @param parentTaskId the parent task id
	 * @return the parent task by id
	 */
	@RequestMapping(value = "/view/{parentTaskId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ParentTaskDto getParentTaskById(@PathVariable final int parentTaskId) {
		return parentTaskDomain.getParentTaskById(parentTaskId);
	}
} 