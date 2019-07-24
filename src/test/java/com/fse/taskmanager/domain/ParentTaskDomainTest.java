package com.fse.taskmanager.domain;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fse.taskmanager.domain.ParentTaskDomain;
import com.fse.taskmanager.dto.ParentTaskDto;
import com.fse.taskmanager.entity.ParentTaskEO;
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
    	ParentTaskDto dto = new ParentTaskDto();
    	dto.setParentId(1);
    	dto.setParentTask("Parent");
        final List<ParentTaskDto> expectedResult = Arrays.asList(dto);
        ParentTaskEO eo1 = new ParentTaskEO();
        eo1.setParentId(1);
        eo1.setParentTask("Parent");
        when(mockParentTaskRepo.findAll()).thenReturn(Arrays.asList(eo1));

        // Run the test
        final List<ParentTaskDto> result = parentTaskDomainUnderTest.getParentTasks();

        // Verify the results
        Assert.assertEquals(expectedResult.get(0).getParentTask(), result.get(0).getParentTask());
    }

    @Test
    public void testGetParentTaskById() {
        // Setup
        final ParentTaskDto expectedResult = new ParentTaskDto();
        when(mockParentTaskRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(new ParentTaskEO());

        // Run the test
        final ParentTaskDto result = parentTaskDomainUnderTest.getParentTaskById(1);

    }
}
