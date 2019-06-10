package com.fse.taskmanager.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fse.taskmanager.dto.ParentTaskDto;
import com.fse.taskmanager.dto.TaskDto;
import com.fse.taskmanager.entity.ParentTaskEO;
import com.fse.taskmanager.entity.TaskEO;
import com.fse.taskmanager.repository.IParentTaskRepository;
import com.fse.taskmanager.repository.ITaskRepositroy;

/**
 * The Class TaskManagerDomain.
 */
@Component
public class TaskManagerDomain implements ITaskManagerDomain {

	
	/** The task repo. */
	@Autowired
	private ITaskRepositroy taskRepo;
	/** The task repo. */
	@Autowired
	private IParentTaskRepository parentTaskRepo;
	
	/**
	 * view task method.
	 *
	 * @return the list
	 */
	@Override
	@Transactional(readOnly = true)
	public List<TaskDto> viewTask() {
		final List<TaskEO> taskEos = taskRepo.findAll();
		final List<TaskDto> taskResponse = new ArrayList<>();
		taskEos.stream().forEach(task->{
			final TaskDto taskDto = new TaskDto();
			taskDto.setTaskId(task.getTaskId());
			taskDto.setTask(task.getTask());
			taskDto.setStartDate(task.getStartDate());
			taskDto.setEndDate(task.getEndDate());
			taskDto.setPriority(task.getPriority());
			if(null!=task.getParentTask()) {
				final ParentTaskDto parentTask = new ParentTaskDto();
				parentTask.setParentId(task.getParentTask().getParentId());
				parentTask.setParentTask(task.getParentTask().getParentTask());
				taskDto.setParentTask(parentTask);
			}
			taskResponse.add(taskDto);
		});
		return taskResponse;
	}

	/**
	 * Adds the task.
	 *
	 * @param taskDto the task dto
	 * @return the task dto
	 */
	@Override
	@Transactional(readOnly = false)
	public TaskDto addTask(final TaskDto taskDto) {
		final TaskEO taskEo = new TaskEO();
		taskEo.setTask(taskDto.getTask());
		taskEo.setPriority(taskDto.getPriority());
		taskEo.setStartDate(taskDto.getStartDate());
		taskEo.setEndDate(taskDto.getEndDate());
		if(null!=taskDto.getParentTask()) {
			final ParentTaskEO parentTaskEo = new ParentTaskEO();
			parentTaskEo.setParentTask(taskDto.getParentTask().getParentTask());
			parentTaskRepo.saveAndFlush(parentTaskEo);
			taskEo.setParentTask(parentTaskEo);
		}
		taskRepo.saveAndFlush(taskEo);
		taskDto.setTaskId(taskEo.getTaskId());
		if(null!=taskEo.getParentTask()) {
			final ParentTaskDto parentTask = new ParentTaskDto();
			parentTask.setParentId(taskEo.getParentTask().getParentId());
			taskDto.setParentTask(parentTask);
		}
		return taskDto;
	}
	/**
	 * Delete task.
	 *
	 * @param taskDto the task dto
	 * @return true, if successful
	 */
	@Override
	public boolean deleteTask(final TaskDto taskDto) {
		boolean deleteTask = false;
		if(taskDto.getTaskId()>0) {
			taskRepo.deleteById(taskDto.getTaskId());
			deleteTask = true;
		}
		return deleteTask;
	}

}
