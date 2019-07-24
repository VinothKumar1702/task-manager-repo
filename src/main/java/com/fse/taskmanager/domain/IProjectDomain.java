/*
 * 
 */
package com.fse.taskmanager.domain;

import java.util.List;

import com.fse.taskmanager.dto.ProjectDto;

// TODO: Auto-generated Javadoc
/**
 * The Interface IProjectDomain.
 */
public interface IProjectDomain {

	/**
	 * Update project.
	 *
	 * @param projectDto the project dto
	 * @return the project dto
	 */
	ProjectDto updateProject(ProjectDto projectDto);

	/**
	 * Delete project.
	 *
	 * @param projectId the project id
	 * @return true, if successful
	 */
	boolean deleteProject(int projectId);

	/**
	 * Adds the project.
	 *
	 * @param projectDto the project dto
	 * @return the project dto
	 */
	ProjectDto addProject(ProjectDto projectDto);

	/**
	 * View projects.
	 *
	 * @return the list
	 */
	List<ProjectDto> viewProjects();

	/**
	 * Gets the project.
	 *
	 * @param projectId the project id
	 * @return the project
	 */
	ProjectDto getProject(int projectId);

	/**
	 * Gets the project tasks.
	 *
	 * @param projectId the project id
	 * @return the project tasks
	 */
	int getProjectTasks(int projectId);

	/**
	 * Gets the completed.
	 *
	 * @param projectId the project id
	 * @return the completed
	 */
	int getcompleted(int projectId);

	/**
	 * Gets the project by P name.
	 *
	 * @param project the project
	 * @return the project by P name
	 */
	ProjectDto getProjectByPName(String project);

}
