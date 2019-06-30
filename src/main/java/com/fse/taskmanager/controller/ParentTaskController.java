package com.fse.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fse.taskmanager.domain.IParentTaskDomain;
import com.fse.taskmanager.dto.ParentTaskDto;


@RestController
@RequestMapping("/parent-task")
public class ParentTaskController {

	
	@Autowired
	private IParentTaskDomain parentTaskDomain;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ParentTaskDto> getParentTasks() {
		return parentTaskDomain.getParentTasks();
	}
} 