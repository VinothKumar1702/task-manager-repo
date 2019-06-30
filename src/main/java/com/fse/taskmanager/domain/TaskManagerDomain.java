package com.fse.taskmanager.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
				
				taskDto.setParentId(task.getParentTask().getParentId());
				taskDto.setParentTask(task.getParentTask().getParentTask());
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
		if (taskDto.isParentTaskFlag()) {
			ParentTaskEO pTask = new ParentTaskEO();
			pTask.setParentTask(taskDto.getTask());
			parentTaskRepo.saveAndFlush(pTask);
		} else {
			final TaskEO taskEo = new TaskEO();
			taskEo.setTask(taskDto.getTask());
			taskEo.setPriority(taskDto.getPriority());
			taskEo.setStartDate(taskDto.getStartDate());
			taskEo.setEndDate(taskDto.getEndDate());
			if (null != taskDto.getParentTask()) {
				final ParentTaskEO parentTaskEo = new ParentTaskEO();
				parentTaskEo.setParentTask(taskDto.getParentTask());
				parentTaskRepo.saveAndFlush(parentTaskEo);
				taskEo.setParentTask(parentTaskEo);
			}
			taskRepo.saveAndFlush(taskEo);
			taskDto.setTaskId(taskEo.getTaskId());
			if (null != taskEo.getParentTask()) {
				taskDto.setParentId(taskEo.getParentTask().getParentId());
				taskDto.setParentTask(taskEo.getParentTask().getParentTask());
			}
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
	public boolean deleteTask(int taskId) {
		boolean deleteTask = false;
		if(taskId>0) {
			taskRepo.deleteById(taskId);
			deleteTask = true;
		}
		return deleteTask;
	}

	@Override
	@Transactional(readOnly = false)
	public TaskDto updateTask(TaskDto task) {
		TaskEO	t = taskRepo.getOne(task.getTaskId());
		if(task.getParentId()>1) {
			ParentTaskEO parentTask = parentTaskRepo.getOne(task.getParentId());
			parentTask.setParentTask(task.getParentTask());
			parentTaskRepo.save(parentTask);
		}
		t.setTask(task.getTask());
		t.setStartDate(task.getStartDate());
		t.setEndDate(task.getEndDate());
		t.setPriority(task.getPriority());
		taskRepo.save(t);
		return task;
	}

}
