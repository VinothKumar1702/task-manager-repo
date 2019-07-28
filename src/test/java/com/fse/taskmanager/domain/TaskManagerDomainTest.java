package com.fse.taskmanager.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fse.taskmanager.dto.TaskDto;
import com.fse.taskmanager.entity.ParentTaskEO;
import com.fse.taskmanager.entity.ProjectEO;
import com.fse.taskmanager.entity.TaskEO;
import com.fse.taskmanager.entity.UsersEO;
import com.fse.taskmanager.repository.IParentTaskRepository;
import com.fse.taskmanager.repository.IProjectRepository;
import com.fse.taskmanager.repository.ITaskRepositroy;
import com.fse.taskmanager.repository.IUserRepository;

/**
 * The Class TaskManagerDomainTest.
 */
public class TaskManagerDomainTest {

    /** The mock task repo. */
    @Mock
    private ITaskRepositroy mockTaskRepo;
    
    /** The mock parent task repo. */
    @Mock
    private IParentTaskRepository mockParentTaskRepo;
    
    /** The mock user repo. */
    @Mock
    private IUserRepository mockUserRepo;
    
    /** The mock project repo. */
    @Mock
    private IProjectRepository mockProjectRepo;

    /** The task manager domain under test. */
    @InjectMocks
    private TaskManagerDomain taskManagerDomainUnderTest;

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
        // Setup
    	final TaskDto dto = getTaskDto();
    	final TaskEO taskEo = getTaskEO();
        final List<TaskDto> expectedResult = Arrays.asList(dto);
        when(mockTaskRepo.findAll()).thenReturn(Arrays.asList(taskEo));

        // Run the test
        final List<TaskDto> result = taskManagerDomainUnderTest.viewTask();

        // Verify the results
        assertEquals(expectedResult.get(0).getTask(), result.get(0).getTask());
    }

    /**
     * Gets the task EO.
     *
     * @return the task EO
     */
    private TaskEO getTaskEO() {
    	final TaskEO taskEo= new TaskEO();
    	taskEo.setTask("Task");
    	taskEo.setTaskId(1);
    	taskEo.setStatus("COMPLETED");
    	taskEo.setEndDate(new Date());
    	taskEo.setStartDate(new Date());
    	taskEo.setPriority(2);
    	final ParentTaskEO parentTask = getParentTaskEO();
    	taskEo.setParentTask(parentTask);
		final ProjectEO project = getProjectEO();
		taskEo.setProject(project);
		final UsersEO userEo = getUsersEO();
		taskEo.setUser(userEo);
		return taskEo;
	}

	/**
	 * @return
	 */
	private ParentTaskEO getParentTaskEO() {
		final ParentTaskEO parentTask = new ParentTaskEO();
    	parentTask.setParentId(1);
    	parentTask.setParentTask("Parent");
		return parentTask;
	}

	/**
	 * Gets the task dto.
	 *
	 * @return the task dto
	 */
	private TaskDto getTaskDto() {
		final TaskDto dto = new TaskDto();
		dto.setCompleted("COMPLETED");
		dto.setEndDate("2019-06-01");
		dto.setStartDate("2018-06-01");
		dto.setParentId(1);
		dto.setParentTask("Parent");
		dto.setParentTaskFlag(false);
		dto.setPriority(2);
		dto.setProject("Project");
		dto.setProjectId(1);
		dto.setTaskId(1);
		dto.setTask("Task");
		dto.setUser("vinoth");
		dto.setUserId(17);
		return dto;
	}

	/**
	 * Test add task.
	 */
	@Test
    public void testAddTask() {
        // Setup
        final TaskDto taskDto = getTaskDto();
        final TaskDto expectedResult = getTaskDto();
        final ParentTaskEO parentTask = getParentTaskEO();
    	final ProjectEO project = getProjectEO();
		final UsersEO userEo = getUsersEO();
        when(mockParentTaskRepo.saveAndFlush(ArgumentMatchers.any(ParentTaskEO.class))).thenReturn(parentTask);
        when(mockParentTaskRepo.fetchParentTaskByName(ArgumentMatchers.anyString())).thenReturn(parentTask);
        when(mockProjectRepo.getProjectByPName(ArgumentMatchers.anyString())).thenReturn(project);
        when(mockUserRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(userEo);
        when(mockTaskRepo.saveAndFlush(ArgumentMatchers.any(TaskEO.class))).thenReturn(getTaskEO());

        // Run the test
        final TaskDto result = taskManagerDomainUnderTest.addTask(taskDto);

        // Verify the results
        assertEquals(expectedResult.getTask(), result.getTask());
    }
	
	@Test
    public void testAddParentTask() {
        // Setup
        final TaskDto taskDto = getTaskDto();
        taskDto.setParentTaskFlag(true);
        final TaskDto expectedResult = getTaskDto();
        final ParentTaskEO parentTask = getParentTaskEO();
    	final ProjectEO project = getProjectEO();
		final UsersEO userEo = getUsersEO();
        when(mockParentTaskRepo.saveAndFlush(ArgumentMatchers.any(ParentTaskEO.class))).thenReturn(parentTask);
        when(mockParentTaskRepo.fetchParentTaskByName(ArgumentMatchers.anyString())).thenReturn(parentTask);
        when(mockProjectRepo.getProjectByPName(ArgumentMatchers.anyString())).thenReturn(project);
        when(mockUserRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(userEo);
        when(mockTaskRepo.saveAndFlush(ArgumentMatchers.any(TaskEO.class))).thenReturn(getTaskEO());

        // Run the test
        final TaskDto result = taskManagerDomainUnderTest.addTask(taskDto);

        // Verify the results
        assertEquals(expectedResult.getParentTask(), result.getParentTask());
    }

	/**
	 * @return
	 */
	private UsersEO getUsersEO() {
		final UsersEO userEo = new UsersEO();
		userEo.setFirstName("vinoth");
		userEo.setLastName("kumar");
		userEo.setEmployeeId(1);
		userEo.setUserID(17);
		return userEo;
	}

	/**
	 * @return
	 */
	private ProjectEO getProjectEO() {
		final ProjectEO project = new ProjectEO();
		project.setProjectName("Project");
		project.setProjectId(1);
		return project;
	}

    /**
     * Test end task.
     */
    @Test
    public void testEndTask() {
        // Setup
        final int taskId = 1;
        when(mockTaskRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(getTaskEO());
        when(mockTaskRepo.save(ArgumentMatchers.any(TaskEO.class))).thenReturn(getTaskEO());

        // Run the test
        final boolean result = taskManagerDomainUnderTest.endTask(taskId);

        // Verify the results
        assertTrue(result);
    }

    /**
     * Test update task.
     */
    @Test
    public void testUpdateTask() {
        // Setup
        final TaskDto task = getTaskDto();
        final TaskDto expectedResult = getTaskDto();
        when(mockTaskRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(getTaskEO());
        when(mockParentTaskRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(getParentTaskEO());
        when(mockProjectRepo.getProjectByPName(ArgumentMatchers.anyString())).thenReturn(getProjectEO());
        when(mockUserRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(getUsersEO());
        when(mockTaskRepo.save(ArgumentMatchers.any(TaskEO.class))).thenReturn(getTaskEO());

        // Run the test
        final TaskDto result = taskManagerDomainUnderTest.updateTask(task);

        // Verify the results
        assertEquals(expectedResult.getTask(), result.getTask());
    }

    /**
     * Test view task by id.
     */
    @Test
    public void testViewTaskById() {
        // Setup
        final int taskId = 1;
        final TaskDto expectedResult = getTaskDto();
        when(mockTaskRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(getTaskEO());

        // Run the test
        final TaskDto result = taskManagerDomainUnderTest.viewTaskById(taskId);

        // Verify the results
        assertEquals(expectedResult.getTask(), result.getTask());
    }

    /**
     * Test view task by project.
     */
    @Test
    public void testViewTaskByProject() {
        // Setup
        final int projectId = 1;
        final List<TaskDto> expectedResult = Arrays.asList(getTaskDto());
        when(mockTaskRepo.findProjects(ArgumentMatchers.anyInt())).thenReturn(Arrays.asList(getTaskEO()));

        // Run the test
        final List<TaskDto> result = taskManagerDomainUnderTest.viewTaskByProject(projectId);

        // Verify the results
        assertEquals(expectedResult.get(0).getTask(), result.get(0).getTask());
    }
}
