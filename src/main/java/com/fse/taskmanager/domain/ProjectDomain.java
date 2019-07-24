/*
 * 
 */
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

/**
 * The Class ProjectDomain.
 */
@Component
public class ProjectDomain implements IProjectDomain {

	/** The project repo. */
	@Autowired
	private IProjectRepository projectRepo;

	/** The user repo. */
	@Autowired
	private IUserRepository userRepo;
	
	/** The task repo. */
	@Autowired
	private ITaskRepositroy taskRepo;

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IProjectDomain#viewProjects()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ProjectDto> viewProjects() {
		final List<ProjectEO> projectEos = projectRepo.findAll();
		final List<ProjectDto> projectDtos = new ArrayList<>();
		projectEos.forEach(eo -> {
			final ProjectDto dto = new ProjectDto();
			dto.setProjectId(eo.getProjectId());
			dto.setPriority(eo.getPriority());
			dto.setProject(eo.getProjectName());
			dto.setStartDate(eo.getStartDate());
			dto.setEndDate(eo.getEndDate());
			dto.setTasks(getProjectTasks(eo.getProjectId()));
			dto.setCompleted(getcompleted(eo.getProjectId()));
			if (null!=eo.getUserEo()) {
				dto.setManager(eo.getUserEo().getFirstName()+" "+eo.getUserEo().getLastName());
				dto.setUserId(eo.getUserEo().getUserID());
			}
			projectDtos.add(dto);
		});
		return projectDtos;
	}

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IProjectDomain#updateProject(com.fse.taskmanager.dto.ProjectDto)
	 */
	@Override
	@Transactional(readOnly = false)
	public ProjectDto updateProject(final ProjectDto projectDto) {
		final ProjectEO projectEo = projectRepo.getOne(projectDto.getProjectId());
		getProject(projectDto, projectEo);
		if (projectDto.getUserId() > 0) {
			final UsersEO userEo = userRepo.getOne(projectDto.getUserId());
			projectEo.setUserEo(userEo);
		}
		projectRepo.save(projectEo);
		return projectDto;
	}

	/**
	 * Gets the project.
	 *
	 * @param projectDto the project dto
	 * @param projectEo the project eo
	 * @return the project
	 */
	private void getProject(final ProjectDto projectDto, final ProjectEO projectEo) {
		projectEo.setProjectName(projectDto.getProject());
		projectEo.setPriority(projectDto.getPriority());
		projectEo.setStartDate(projectDto.getStartDate());
		projectEo.setEndDate(projectDto.getEndDate());
	}

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IProjectDomain#deleteProject(int)
	 */
	@Override
	@Transactional(readOnly = false)
	public boolean deleteProject(final int projectId) {
		boolean deleteProject = false;
		if (projectId > 0) {
			projectRepo.deleteById(projectId);
			deleteProject = true;
		}
		return deleteProject;
	}

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IProjectDomain#addProject(com.fse.taskmanager.dto.ProjectDto)
	 */
	@Override
	@Transactional(readOnly = false)
	public ProjectDto addProject(final ProjectDto projectDto) {
		final ProjectEO projectEo = new ProjectEO();
		getProject(projectDto, projectEo);
		if (projectDto.getUserId() > 0) {
			final UsersEO userEo = userRepo.getOne(projectDto.getUserId());
			projectEo.setUserEo(userEo);
		}
		projectRepo.save(projectEo);
		projectDto.setProjectId(projectEo.getProjectId());
		return projectDto;
	}

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IProjectDomain#getProject(int)
	 */
	@Override
	public ProjectDto getProject(final int projectId) {
		final ProjectDto response = new ProjectDto();
		final ProjectEO projectEo = projectRepo.getOne(projectId);
		response.setProjectId(projectEo.getProjectId());
		response.setProject(projectEo.getProjectName());
		response.setPriority(projectEo.getPriority());
		response.setStartDate(projectEo.getStartDate());
		response.setEndDate(projectEo.getEndDate());
		if (null!=projectEo.getUserEo()) {
			response.setManager(projectEo.getUserEo().getFirstName()+" "+projectEo.getUserEo().getLastName());
			response.setUserId(projectEo.getUserEo().getUserID());
		}
		return response;
	}

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IProjectDomain#getProjectTasks(int)
	 */
	@Override
	public int getProjectTasks(final int projectId) {
		final List<TaskEO> tasks = taskRepo.findProjects(projectId);
		return tasks.size();
	}

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IProjectDomain#getcompleted(int)
	 */
	@Override
	public int getcompleted(final int projectId) {
		final List<TaskEO> tasks = taskRepo.getcompletedProjects(projectId);
		return tasks.size();
	}

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IProjectDomain#getProjectByPName(java.lang.String)
	 */
	@Override
	public ProjectDto getProjectByPName(final String project) {
		final ProjectDto dto = new ProjectDto();
		final ProjectEO eo = projectRepo.getProjectByPName(project);
		dto.setProjectId(eo.getProjectId());
		dto.setPriority(eo.getPriority());
		dto.setProject(eo.getProjectName());
		dto.setStartDate(eo.getStartDate());
		dto.setEndDate(eo.getEndDate());
		dto.setTasks(getProjectTasks(eo.getProjectId()));
		dto.setCompleted(getcompleted(eo.getProjectId()));
		if (null!=eo.getUserEo()) {
			dto.setManager(eo.getUserEo().getFirstName()+" "+eo.getUserEo().getLastName());
			dto.setUserId(eo.getUserEo().getUserID());
		}
		return dto;
	}

}
