package com.fse.taskmanager.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.taskmanager.domain.TaskManagerDomain;
import com.fse.taskmanager.dto.TaskDto;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskManagerControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskManagerControllerTest {

	/** The controller. */
	@InjectMocks
	private TaskManagerController controller;

	/** The task manager domain. */
	@Mock
	private TaskManagerDomain taskManagerDomain;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		initMocks(this);
	}

	/**
	 * Test view task.
	 */
	@Test
	public void testViewTask() {
		final List<TaskDto> result = Arrays.asList();
		final List<TaskDto> viewTaskResponse = controller.viewTask();
		assertEquals(viewTaskResponse, result);
	}

	/**
	 * Test view task by id.
	 */
	@Test
	public void testViewTaskById() {
		final TaskDto dto = controller.viewTaskById(ArgumentMatchers.anyInt());
	}
	
	/**
	 * Test view task by project.
	 */
	@Test
	public void testViewTaskByProject() {
		final List<TaskDto> dtos = controller.viewTaskByProject(ArgumentMatchers.anyInt());
		assertEquals(dtos, new ArrayList<>());
	}
	
	/**
	 * Test add task.
	 */
	@Test
	public void testAddTask() {
		final TaskDto addTask = controller.addTask(new TaskDto());
	}
	
	/**
	 * Test update task.
	 */
	@Test
	public void testUpdateTask() {
		final TaskDto updateTask = controller.updateTask(new TaskDto());
	}
	
	/**
	 * Test end task.
	 */
	@Test
	public void testEndTask() {
		final boolean endTask = controller.endTask(ArgumentMatchers.anyInt());
		assertEquals(endTask, false);
	}
	
}
