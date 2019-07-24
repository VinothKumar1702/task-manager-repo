package com.fse.taskmanager.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.taskmanager.domain.IParentTaskDomain;
import com.fse.taskmanager.dto.ParentTaskDto;

// TODO: Auto-generated Javadoc
/**
 * The Class ParentTaskControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentTaskControllerTest {

	/** The parent task domain. */
	@Mock
	private IParentTaskDomain parentTaskDomain;
	
	/** The controller. */
	@InjectMocks
	private ParentTaskController controller;
	
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
