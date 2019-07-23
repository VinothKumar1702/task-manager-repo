package com.fse.taskmanager.controler;

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

import com.fse.taskmanager.controller.TaskManagerController;
import com.fse.taskmanager.domain.TaskManagerDomain;
import com.fse.taskmanager.dto.TaskDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskManagerControllerTest {

	@InjectMocks
	private TaskManagerController controller;

	@Mock
	private TaskManagerDomain taskManagerDomain;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void testViewTask() {
		List<TaskDto> result = Arrays.asList();
		List<TaskDto> viewTaskResponse = controller.viewTask();
		assertEquals(viewTaskResponse, result);
	}

	@Test
	public void testViewTaskById() {
		TaskDto dto = controller.viewTaskById(ArgumentMatchers.anyInt());
	}
	
	@Test
	public void testViewTaskByProject() {
		List<TaskDto> dtos = controller.viewTaskByProject(ArgumentMatchers.anyInt());
		assertEquals(dtos, new ArrayList<>());
	}
	
	@Test
	public void testAddTask() {
		final TaskDto addTask = controller.addTask(new TaskDto());
	}
	
	@Test
	public void testUpdateTask() {
		final TaskDto updateTask = controller.updateTask(new TaskDto());
	}
	
	@Test
	public void testEndTask() {
		boolean endTask = controller.endTask(ArgumentMatchers.anyInt());
		assertEquals(endTask, true);
	}
	
}
