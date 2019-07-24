package com.fse.taskmanager.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fse.taskmanager.domain.ProjectDomain;
import com.fse.taskmanager.dto.ProjectDto;
import com.fse.taskmanager.entity.ProjectEO;
import com.fse.taskmanager.entity.UsersEO;
import com.fse.taskmanager.repository.IProjectRepository;
import com.fse.taskmanager.repository.ITaskRepositroy;
import com.fse.taskmanager.repository.IUserRepository;

public class ProjectDomainTest {

    @Mock
    private IProjectRepository mockProjectRepo;
    @Mock
    private IUserRepository mockUserRepo;
    @Mock
    private ITaskRepositroy mockTaskRepo;

    @InjectMocks
    private ProjectDomain projectDomainUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testViewProjects() {
        // Setup
        final List<ProjectDto> expectedResult = getProjects();
        List<ProjectEO> listEo = getProjectEo();
        when(mockProjectRepo.findAll()).thenReturn(listEo);
        when(mockTaskRepo.findProjects(0)).thenReturn(Arrays.asList());
        when(mockTaskRepo.getcompletedProjects(0)).thenReturn(Arrays.asList());

        // Run the test
        final List<ProjectDto> result = projectDomainUnderTest.viewProjects();

        // Verify the results
        assertEquals(expectedResult.get(0).getProject(), result.get(0).getProject());
    }

    private List<ProjectEO> getProjectEo() {
    	ProjectEO eo = projectEO();
		return Arrays.asList(eo);
	}

	private ProjectEO projectEO() {
		ProjectEO eo = new ProjectEO();
    	eo.setEndDate(new Date());
    	eo.setPriority(1);
    	eo.setProjectName("Project");
    	eo.setProjectId(1);
    	eo.setStartDate(new Date());
    	UsersEO usereo = new UsersEO();
    	usereo.setUserID(1);
    	usereo.setEmployeeId(12);
    	usereo.setFirstName("vinoth");
    	usereo.setLastName("kumar");
    	eo.setUserEo(usereo);
		return eo;
	}

	private List<ProjectDto> getProjects() {
    	ProjectDto dto = projectDto();
		return Arrays.asList(dto);
	}

	private ProjectDto projectDto() {
		ProjectDto dto = new ProjectDto();
		dto.setCompleted(1);
    	dto.setEndDate(new Date());
    	dto.setManager("Vinoth");
    	dto.setPriority(1);
    	dto.setProject("Project");
    	dto.setProjectId(1);
    	dto.setStartDate(new Date());
    	dto.setTasks(2);
    	dto.setUserId(1);
		return dto;
	}

	@Test
    public void testUpdateProject() {
        // Setup
        final ProjectDto projectDto = projectDto();
        final ProjectDto expectedResult = projectDto();
        ProjectEO eo = projectEO();
        when(mockProjectRepo.getOne(1)).thenReturn(eo);
        when(mockUserRepo.getOne(null)).thenReturn(null);
        when(mockProjectRepo.save(null)).thenReturn(null);

        // Run the test
        final ProjectDto result = projectDomainUnderTest.updateProject(projectDto);

        // Verify the results
        assertEquals(expectedResult.getProject(), result.getProject());
    }

    @Test
    public void testDeleteProject() {
        // Setup
        final int projectId = 1;

        // Run the test
        final boolean result = projectDomainUnderTest.deleteProject(projectId);

        // Verify the results
        assertTrue(result);
        verify(mockProjectRepo).deleteById(1);
    }

    @Test
    public void testAddProject() {
        // Setup
        final ProjectDto projectDto = projectDto();
        final ProjectDto expectedResult = projectDto();
        ProjectEO eo = projectEO();
        when(mockUserRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(new UsersEO());
        when(mockProjectRepo.save(eo)).thenReturn(eo);

        // Run the test
        final ProjectDto result = projectDomainUnderTest.addProject(projectDto);

        // Verify the results
        assertEquals(expectedResult.getProject(), result.getProject());
    }

    @Test
    public void testGetProject1() {
        // Setup
        final int projectId = 1;
        final ProjectDto expectedResult = projectDto();
        ProjectEO eo = projectEO();
        when(mockProjectRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(eo);

        // Run the test
        final ProjectDto result = projectDomainUnderTest.getProject(projectId);

        // Verify the results
        assertEquals(expectedResult.getProject(), result.getProject());
    }

    @Test
    public void testGetProjectTasks() {
        // Setup
        final int projectId = 1;
        final int expectedResult = 0;
        when(mockTaskRepo.findProjects(ArgumentMatchers.anyInt())).thenReturn(Arrays.asList());

        // Run the test
        final int result = projectDomainUnderTest.getProjectTasks(projectId);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetcompleted() {
        // Setup
        final int projectId = 0;
        final int expectedResult = 0;
        when(mockTaskRepo.getcompletedProjects(0)).thenReturn(Arrays.asList());

        // Run the test
        final int result = projectDomainUnderTest.getcompleted(projectId);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetProjectByPName() {
        // Setup
        final String project = "Project";
        final ProjectDto expectedResult = projectDto();
        when(mockProjectRepo.getProjectByPName(ArgumentMatchers.anyString())).thenReturn(projectEO());
        when(mockTaskRepo.findProjects(1)).thenReturn(Arrays.asList());
        when(mockTaskRepo.getcompletedProjects(1)).thenReturn(Arrays.asList());

        // Run the test
        final ProjectDto result = projectDomainUnderTest.getProjectByPName(project);

        // Verify the results
        assertEquals(expectedResult.getProject(), result.getProject());
    }
}
