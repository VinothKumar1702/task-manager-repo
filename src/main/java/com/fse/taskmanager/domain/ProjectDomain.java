package com.fse.taskmanager.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fse.taskmanager.dto.ProjectDto;
import com.fse.taskmanager.entity.ProjectEO;
import com.fse.taskmanager.entity.TaskEO;
import com.fse.taskmanager.entity.UsersEO;
import com.fse.taskmanager.repository.IProjectRepository;
import com.fse.taskmanager.repository.ITaskRepositroy;
import com.fse.taskmanager.repository.IUserRepository;

@Component
public class ProjectDomain implements IProjectDomain {

	@Autowired
	private IProjectRepository projectRepo;

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private ITaskRepositroy taskRepo;

	@Override
	@Transactional(readOnly = true)
	public List<ProjectDto> viewProjects() {
		List<ProjectEO> projectEos = projectRepo.findAll();
		List<ProjectDto> projectDtos = new ArrayList<>();
		projectEos.forEach(eo -> {
			ProjectDto dto = new ProjectDto();
			dto.setProjectId(eo.getProjectId());
			dto.setPriority(eo.getPriority());
			dto.setProject(eo.getProjectName());
			dto.setStartDate(eo.getStartDate());
			dto.setEndDate(eo.getEndDate());
			dto.setTasks(getProjectTasks(eo.getProjectId()));
			dto.setCompleted(getcompleted(eo.getProjectId()));
			UsersEO userEo = userRepo.getManager(eo.getProjectId());
			if (null != userEo) {
				dto.setManager(userEo.getFirstName()+" "+userEo.getLastName());
				dto.setUserId(userEo.getUserID());
			}
			projectDtos.add(dto);
		});
		return projectDtos;
	}

	@Override
	@Transactional(readOnly = false)
	public ProjectDto updateProject(ProjectDto projectDto) {
		ProjectEO projectEo = projectRepo.getOne(projectDto.getProjectId());
		getProject(projectDto, projectEo);
		if (projectDto.getUserId() > 0) {
			UsersEO userEo = userRepo.getOne(projectDto.getUserId());
			userEo.setProject(projectEo);
			userRepo.save(userEo);
		}
		projectRepo.save(projectEo);
		return projectDto;
	}

	private void getProject(ProjectDto projectDto, ProjectEO projectEo) {
		projectEo.setProjectName(projectDto.getProject());
		projectEo.setPriority(projectDto.getPriority());
		projectEo.setStartDate(projectDto.getStartDate());
		projectEo.setEndDate(projectDto.getEndDate());
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteProject(int projectId) {
		boolean deleteProject = false;
		if (projectId > 0) {
			projectRepo.deleteById(projectId);
			deleteProject = true;
		}
		return deleteProject;
	}

	@Override
	@Transactional(readOnly = false)
	public ProjectDto addProject(ProjectDto projectDto) {
		ProjectEO projectEo = new ProjectEO();
		getProject(projectDto, projectEo);
		if (projectDto.getUserId() > 0) {
			UsersEO userEo = userRepo.getOne(projectDto.getUserId());
			userEo.setUserID(projectDto.getUserId());
			userEo.setProject(projectEo);
			userRepo.save(userEo);
		}
		projectRepo.save(projectEo);
		projectDto.setProjectId(projectEo.getProjectId());
		return projectDto;
	}

	@Override
	public ProjectDto getProject(int projectId) {
		ProjectDto response = new ProjectDto();
		ProjectEO projectEo = projectRepo.getOne(projectId);
		response.setProjectId(projectEo.getProjectId());
		response.setProject(projectEo.getProjectName());
		response.setPriority(projectEo.getPriority());
		response.setStartDate(projectEo.getStartDate());
		response.setEndDate(projectEo.getEndDate());
		UsersEO userEo = userRepo.getManager(projectEo.getProjectId());
		if (null != userEo) {
			response.setManager(userEo.getFirstName());
			response.setUserId(userEo.getUserID());
		}
		return response;
	}

	@Override
	public int getProjectTasks(int projectId) {
		List<TaskEO> tasks = taskRepo.findProjects(projectId);
		return tasks.size();
	}

	@Override
	public int getcompleted(int projectId) {
		List<TaskEO> tasks = taskRepo.getcompletedProjects(projectId);
		return tasks.size();
	}

	@Override
	public ProjectDto getProjectByPName(String project) {
		ProjectDto dto = new ProjectDto();
		ProjectEO eo = projectRepo.getProjectByPName(project);
		dto.setProjectId(eo.getProjectId());
		dto.setPriority(eo.getPriority());
		dto.setProject(eo.getProjectName());
		dto.setStartDate(eo.getStartDate());
		dto.setEndDate(eo.getEndDate());
		dto.setTasks(getProjectTasks(eo.getProjectId()));
		dto.setCompleted(getcompleted(eo.getProjectId()));
		UsersEO userEo = userRepo.getManager(eo.getProjectId());
		if (null != userEo) {
			dto.setManager(userEo.getFirstName()+" "+userEo.getLastName());
			dto.setUserId(userEo.getUserID());
		}
		return dto;
	}

}
