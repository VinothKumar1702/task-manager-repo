package com.fse.taskmanager.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fse.taskmanager.dto.TaskDto;
import com.fse.taskmanager.repository.IParentTaskRepository;
import com.fse.taskmanager.repository.IProjectRepository;
import com.fse.taskmanager.repository.ITaskRepositroy;
import com.fse.taskmanager.repository.IUserRepository;

public class TaskManagerDomainTest {

    @Mock
    private ITaskRepositroy mockTaskRepo;
    @Mock
    private IParentTaskRepository mockParentTaskRepo;
    @Mock
    private IUserRepository mockUserRepo;
    @Mock
    private IProjectRepository mockProjectRepo;

    @InjectMocks
    private TaskManagerDomain taskManagerDomainUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testViewTask() {
        // Setup
        final List<TaskDto> expectedResult = Arrays.asList();
        when(mockTaskRepo.findAll()).thenReturn(Arrays.asList());

        // Run the test
        final List<TaskDto> result = taskManagerDomainUnderTest.viewTask();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testAddTask() {
        // Setup
        final TaskDto taskDto = null;
        final TaskDto expectedResult = null;
        when(mockParentTaskRepo.saveAndFlush(null)).thenReturn(null);
        when(mockParentTaskRepo.fetchParentTaskByName("parentTask")).thenReturn(null);
        when(mockProjectRepo.getProjectByPName("project")).thenReturn(null);
        when(mockUserRepo.getOne(null)).thenReturn(null);
        when(mockTaskRepo.saveAndFlush(null)).thenReturn(null);

        // Run the test
        final TaskDto result = taskManagerDomainUnderTest.addTask(taskDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testEndTask() {
        // Setup
        final int taskId = 1;
        when(mockTaskRepo.getOne(null)).thenReturn(null);
        when(mockTaskRepo.save(null)).thenReturn(null);

        // Run the test
        final boolean result = taskManagerDomainUnderTest.endTask(taskId);

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testUpdateTask() {
        // Setup
        final TaskDto task = null;
        final TaskDto expectedResult = null;
        when(mockTaskRepo.getOne(null)).thenReturn(null);
        when(mockParentTaskRepo.getOne(null)).thenReturn(null);
        when(mockProjectRepo.getProjectByPName("project")).thenReturn(null);
        when(mockUserRepo.getOne(null)).thenReturn(null);
        when(mockTaskRepo.save(null)).thenReturn(null);

        // Run the test
        final TaskDto result = taskManagerDomainUnderTest.updateTask(task);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testViewTaskById() {
        // Setup
        final int taskId = 0;
        final TaskDto expectedResult = null;
        when(mockTaskRepo.getOne(null)).thenReturn(null);

        // Run the test
        final TaskDto result = taskManagerDomainUnderTest.viewTaskById(taskId);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testViewTaskByProject() {
        // Setup
        final int projectId = 1;
        final List<TaskDto> expectedResult = Arrays.asList();
        when(mockTaskRepo.findProjects(0)).thenReturn(Arrays.asList());

        // Run the test
        final List<TaskDto> result = taskManagerDomainUnderTest.viewTaskByProject(projectId);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
