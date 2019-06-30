package com.fse.taskmanager.domain;

import java.util.List;

import com.fse.taskmanager.dto.ParentTaskDto;

public interface IParentTaskDomain {

	List<ParentTaskDto> getParentTasks();

}
