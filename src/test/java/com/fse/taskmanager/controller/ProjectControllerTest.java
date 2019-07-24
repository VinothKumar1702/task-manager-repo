package com.fse.taskmanager.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.taskmanager.domain.IProjectDomain;
import com.fse.taskmanager.dto.ProjectDto;

/**
 * The Class ProjectControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectControllerTest {


	/** The project domain. */
	@Mock
	private IProjectDomain projectDomain;
	
	/** The controller. */
	@InjectMocks
	private ProjectController controller;
	
	/**
	 * Test view all project.
	 */
	@Test
	public void testViewAllProject() {
		final List<ProjectDto> response= controller.viewProjects();
	}
	
	/**
	 * Test add project.
	 */
	@Test
	public void testAddProject() {
		final ProjectDto response= controller.addProject(ArgumentMatchers.any(ProjectDto.class));
	}
	
	
	/**
	 * Test update project.
	 */
	@Test
	public void testUpdateProject() {
		final ProjectDto response= controller.updateProject(ArgumentMatchers.any(ProjectDto.class));
	}
	
	
	/**
	 * Test getcompleted.
	 */
	@Test
	public void testGetcompleted() {
		final int response= controller.getcompleted(ArgumentMatchers.anyInt());
	}
	
	/**
	 * Test get project by P name.
	 */
	@Test
	public void testGetProjectByPName() {
		final ProjectDto response= controller.getProjectByPName(ArgumentMatchers.anyString());
	}
	
	/**
	 * Test delete project.
	 */
	@Test
	public void testDeleteProject() {
		final boolean response= controller.deleteProject(ArgumentMatchers.anyInt());
	}
	
	/**
	 * Test get project.
	 */
	@Test
	public void testGetProject() {
		final ProjectDto response= controller.getProject(ArgumentMatchers.anyInt());
	}
	
	@Test
	public void testGetProjectTasks() {
		final int projectDtoReponse = controller.getProjectTasks(ArgumentMatchers.anyInt());
	}

}
