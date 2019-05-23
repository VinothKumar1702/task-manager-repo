package com.fse.taskmanager.domain;

import java.util.List;

import com.fse.taskmanager.dto.TaskManagerResponseDto;

public interface ITaskManagerDomain {

	List<TaskManagerResponseDto> viewTask();

}
