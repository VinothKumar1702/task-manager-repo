package com.fse.taskmanager.domain;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fse.taskmanager.domain.ParentTaskDomain;
import com.fse.taskmanager.dto.ParentTaskDto;
import com.fse.taskmanager.repository.IParentTaskRepository;

public class ParentTaskDomainTest {

    @Mock
    private IParentTaskRepository mockParentTaskRepo;

    @InjectMocks
    private ParentTaskDomain parentTaskDomainUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetParentTasks() {
        // Setup
        final List<ParentTaskDto> expectedResult = Arrays.asList();
        when(mockParentTaskRepo.findAll()).thenReturn(Arrays.asList());

        // Run the test
        final List<ParentTaskDto> result = parentTaskDomainUnderTest.getParentTasks();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetParentTaskById() {
        // Setup
        final int parentTaskId = 0;
        final ParentTaskDto expectedResult = null;
        when(mockParentTaskRepo.getOne(null)).thenReturn(null);

        // Run the test
        final ParentTaskDto result = parentTaskDomainUnderTest.getParentTaskById(parentTaskId);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
