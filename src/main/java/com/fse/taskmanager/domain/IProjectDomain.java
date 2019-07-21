package com.fse.taskmanager.domain;

import java.util.List;

import com.fse.taskmanager.dto.ProjectDto;

public interface IProjectDomain {

	ProjectDto updateProject(ProjectDto projectDto);

	boolean deleteProject(int projectId);

	ProjectDto addProject(ProjectDto projectDto);

	List<ProjectDto> viewProjects();

	ProjectDto getProject(int projectId);

	int getProjectTasks(int projectId);

	int getcompleted(int projectId);

	ProjectDto getProjectByPName(String project);

}
