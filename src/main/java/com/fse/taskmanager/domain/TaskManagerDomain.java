package com.fse.taskmanager.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fse.taskmanager.dto.TaskDto;
import com.fse.taskmanager.entity.ParentTaskEO;
import com.fse.taskmanager.entity.ProjectEO;
import com.fse.taskmanager.entity.TaskEO;
import com.fse.taskmanager.entity.UsersEO;
import com.fse.taskmanager.repository.IParentTaskRepository;
import com.fse.taskmanager.repository.IProjectRepository;
import com.fse.taskmanager.repository.ITaskRepositroy;
import com.fse.taskmanager.repository.IUserRepository;

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

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private IProjectRepository projectRepo;

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
		taskEos.stream().forEach(task -> {
			final TaskDto taskDto = new TaskDto();
			setTaskDetails(task, taskDto);
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
			pTask.setParentTask(taskDto.getTask().trim());
			parentTaskRepo.saveAndFlush(pTask);
			taskDto.setParentId(pTask.getParentId());
		} else {
			if (null != taskDto.getTask()) {
				final TaskEO taskEo = new TaskEO();
				taskEo.setTask(taskDto.getTask());
				taskEo.setPriority(taskDto.getPriority());
				taskEo.setStartDate(taskDto.getStartDate());
				taskEo.setEndDate(taskDto.getEndDate());
				taskEo.setStatus("IN PROGRESS");
				if (null != taskDto.getParentTask()) {
					final ParentTaskEO parentTaskEo = parentTaskRepo.fetchParentTaskByName(taskDto.getParentTask().trim());
					taskEo.setParentTask(parentTaskEo);
				}
				if (null != taskDto.getProject()) {
					ProjectEO projectEO = projectRepo.getProjectByPName(taskDto.getProject());
					taskEo.setProject(projectEO);
				}
				if (taskDto.getUserId() > 0) {
					UsersEO userEo = userRepo.getOne(taskDto.getUserId());
					taskEo.setUser(userEo);
				}
				taskRepo.saveAndFlush(taskEo);
				setTaskDetails(taskEo, taskDto);
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
	@Transactional(readOnly = false)
	public boolean endTask(int taskId) {
		boolean endTask = false;
		if (taskId > 0) {
			TaskEO t = taskRepo.getOne(taskId);
			t.setStatus("COMPLETED");
			taskRepo.save(t);
			endTask = true;
		}
		return endTask;
	}

	@Override
	@Transactional(readOnly = false)
	public TaskDto updateTask(TaskDto task) {
		TaskEO taskEo = taskRepo.getOne(task.getTaskId());
		ParentTaskEO parentTask=null;
		if (task.getParentId() > 0) {
			parentTask = parentTaskRepo.getOne(task.getParentId());
		}else {
			parentTask = new ParentTaskEO();
		}
		taskEo.setParentTask(parentTask);

		if (null != task.getProject()) {
			ProjectEO projectEO = projectRepo.getProjectByPName(task.getProject());
			taskEo.setProject(projectEO);
		}
		if (null != task.getUser()) {
			UsersEO userEo = userRepo.getOne(task.getUserId());
			taskEo.setUser(userEo);
		}
		taskEo.setTask(task.getTask());
		taskEo.setStartDate(task.getStartDate());
		taskEo.setEndDate(task.getEndDate());
		taskEo.setPriority(task.getPriority());
		taskEo.setStatus("IN PROGRESS");
		taskRepo.save(taskEo);
		return task;
	}

	@Override
	@Transactional(readOnly = true)
	public TaskDto viewTaskById(int taskId) {
		TaskEO task = taskRepo.getOne(taskId);
		TaskDto taskDto = new TaskDto();
		setTaskDetails(task, taskDto);
		return taskDto;
	}

	private void setTaskDetails(TaskEO task, TaskDto taskDto) {
		taskDto.setTaskId(task.getTaskId());
		taskDto.setTask(task.getTask());
		taskDto.setStartDate(task.getStartDate());
		taskDto.setEndDate(task.getEndDate());
		taskDto.setPriority(task.getPriority());
		taskDto.setCompleted(task.getStatus());
		if (null != task.getParentTask()) {
			taskDto.setParentId(task.getParentTask().getParentId());
			taskDto.setParentTask(task.getParentTask().getParentTask());
		}
		if (null != task.getProject()) {
			taskDto.setProject(task.getProject().getProjectName());
			taskDto.setProjectId(task.getProject().getProjectId());
		}
		if (null != task.getUser()) {
			taskDto.setUser(task.getUser().getFirstName() + " " + task.getUser().getLastName());
			taskDto.setUserId(task.getUser().getUserID());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TaskDto> viewTaskByProject(int projectId) {
		List<TaskDto> list = new ArrayList<>();
		List<TaskEO> eo = taskRepo.findProjects(projectId);
		eo.stream().forEach(task -> {
			final TaskDto taskDto = new TaskDto();
			setTaskDetails(task, taskDto);
			list.add(taskDto);
		});
		return list;
	}
}
