package com.fse.taskmanager.controller;

import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fse.taskmanager.domain.IParentTaskDomain;
import com.fse.taskmanager.dto.ParentTaskDto;

/**
 * The Class ParentTaskControllerTest.
 */
public class ParentTaskControllerTest {

	/** The parent task domain. */
	@Mock
	private IParentTaskDomain parentTaskDomain;
	
	/** The controller. */
	@InjectMocks
	private ParentTaskController controller;
	
	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		initMocks(this);
	}
	/**
	 * Test get parent tasks.
	 */
	@Test
	public void testGetParentTasks() {
		final List<ParentTaskDto> view = controller.getParentTasks();
	}
	
	/**
	 * Test get parent task by id.
	 */
	@Test
	public void testGetParentTaskById() {
		final ParentTaskDto view = controller.getParentTaskById(ArgumentMatchers.anyInt());
	}
}
