/*
 * 
 */
package com.fse.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fse.taskmanager.domain.IProjectDomain;
import com.fse.taskmanager.dto.ProjectDto;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectController.
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

	/** The project domain. */
	@Autowired
	private IProjectDomain projectDomain;
	
	/**
	 * View projects.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ProjectDto> viewProjects()  {
		final List<ProjectDto> viewProjectResponse = projectDomain.viewProjects();
		return viewProjectResponse;
	}	
	
	/**
	 * Adds the project.
	 *
	 * @param projectDto the project dto
	 * @return the project dto
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ProjectDto addProject(@RequestBody final ProjectDto projectDto)  {
		final ProjectDto projectDtoReponse = projectDomain.addProject(projectDto);
		return projectDtoReponse;
	}
	
	/**
	 * Delete project.
	 *
	 * @param projectId the project id
	 * @return true, if successful
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public boolean deleteProject(@RequestParam final int projectId)  {
		final boolean deleteProject = projectDomain.deleteProject(projectId);
		return deleteProject;
	}
	
	/**
	 * Update project.
	 *
	 * @param projectDto the project dto
	 * @return the project dto
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ProjectDto updateProject(@RequestBody ProjectDto projectDto){
		
		return projectDto = projectDomain.updateProject(projectDto);
	}
	
	/**
	 * Gets the project.
	 *
	 * @param projectId the project id
	 * @return the project
	 */
	@RequestMapping(value = "/getByProjectId/{projectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ProjectDto getProject(@PathVariable final int projectId)  {
		final ProjectDto projectDtoReponse = projectDomain.getProject(projectId);
		return projectDtoReponse;
	}
	
	/**
	 * Gets the project tasks.
	 *
	 * @param projectId the project id
	 * @return the project tasks
	 */
	@RequestMapping(value = "/getProjectTasks/{projectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public int getProjectTasks(@PathVariable final int projectId)  {
		final int projectDtoReponse = projectDomain.getProjectTasks(projectId);
		return projectDtoReponse;
	}
	
	/**
	 * Gets the completed.
	 *
	 * @param projectId the project id
	 * @return the completed
	 */
	@RequestMapping(value = "/getcompleted/{projectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public int getcompleted(@PathVariable final int projectId)  {
		final int projectDtoReponse = projectDomain.getcompleted(projectId);
		return projectDtoReponse;
	}
	
	/**
	 * Gets the project by P name.
	 *
	 * @param projectName the project name
	 * @return the project by P name
	 */
	@RequestMapping(value = "/getprojectByPName/{projectName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ProjectDto getProjectByPName(@PathVariable final String projectName)  {
		final ProjectDto projectDtoReponse = projectDomain.getProjectByPName(projectName);
		return projectDtoReponse;
	}
}
