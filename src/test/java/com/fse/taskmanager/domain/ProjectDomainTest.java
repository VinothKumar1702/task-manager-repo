package com.fse.taskmanager.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fse.taskmanager.domain.ProjectDomain;
import com.fse.taskmanager.dto.ProjectDto;
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
        final List<ProjectDto> expectedResult = Arrays.asList();
        when(mockProjectRepo.findAll()).thenReturn(Arrays.asList());
        when(mockTaskRepo.findProjects(0)).thenReturn(Arrays.asList());
        when(mockTaskRepo.getcompletedProjects(0)).thenReturn(Arrays.asList());

        // Run the test
        final List<ProjectDto> result = projectDomainUnderTest.viewProjects();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testUpdateProject() {
        // Setup
        final ProjectDto projectDto = null;
        final ProjectDto expectedResult = null;
        when(mockProjectRepo.getOne(null)).thenReturn(null);
        when(mockUserRepo.getOne(null)).thenReturn(null);
        when(mockProjectRepo.save(null)).thenReturn(null);

        // Run the test
        final ProjectDto result = projectDomainUnderTest.updateProject(projectDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDeleteProject() {
        // Setup
        final int projectId = 0;

        // Run the test
        final boolean result = projectDomainUnderTest.deleteProject(projectId);

        // Verify the results
        assertTrue(result);
        verify(mockProjectRepo).deleteById(null);
    }

    @Test
    public void testAddProject() {
        // Setup
        final ProjectDto projectDto = null;
        final ProjectDto expectedResult = null;
        when(mockUserRepo.getOne(null)).thenReturn(null);
        when(mockProjectRepo.save(null)).thenReturn(null);

        // Run the test
        final ProjectDto result = projectDomainUnderTest.addProject(projectDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetProject1() {
        // Setup
        final int projectId = 0;
        final ProjectDto expectedResult = null;
        when(mockProjectRepo.getOne(null)).thenReturn(null);

        // Run the test
        final ProjectDto result = projectDomainUnderTest.getProject(projectId);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetProjectTasks() {
        // Setup
        final int projectId = 0;
        final int expectedResult = 0;
        when(mockTaskRepo.findProjects(0)).thenReturn(Arrays.asList());

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
        final String project = "project";
        final ProjectDto expectedResult = null;
        when(mockProjectRepo.getProjectByPName("project")).thenReturn(null);
        when(mockTaskRepo.findProjects(0)).thenReturn(Arrays.asList());
        when(mockTaskRepo.getcompletedProjects(0)).thenReturn(Arrays.asList());

        // Run the test
        final ProjectDto result = projectDomainUnderTest.getProjectByPName(project);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
