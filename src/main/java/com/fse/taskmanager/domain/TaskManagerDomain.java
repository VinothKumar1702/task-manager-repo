package com.fse.taskmanager.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fse.taskmanager.dto.TaskDto;
import com.fse.taskmanager.dto.TaskManagerResponseDto;
import com.fse.taskmanager.entity.ParentTaskEO;
import com.fse.taskmanager.repository.IParentTaskRepository;

@Component
public class TaskManagerDomain implements ITaskManagerDomain {

	@Autowired
	private IParentTaskRepository parentTaskrepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<TaskManagerResponseDto> viewTask() {
		List<ParentTaskEO> parentTaskEos = parentTaskrepo.findAll();
		List<TaskManagerResponseDto> response = new ArrayList<>();
		parentTaskEos.stream().forEach(parent->{
			TaskManagerResponseDto taskManagerDto = new TaskManagerResponseDto();
			taskManagerDto.setParentTask(parent.getParentTask());
			taskManagerDto.setParentId(parent.getParentId());
			List<TaskDto> taskDtoList = new ArrayList<>();
			parent.getTaskList().stream().forEach(task->{
				TaskDto taskDto = new TaskDto();
				taskDto.setTask(task.getTask());
				taskDto.setTaskId(task.getTaskId());
				taskDto.setPriority(task.getPriority());
				taskDtoList.add(taskDto);
			});
			taskManagerDto.setTaskDto(taskDtoList);
			response.add(taskManagerDto);
		});
		return response;
	}

}
