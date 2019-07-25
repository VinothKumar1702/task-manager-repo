package com.fse.taskmanager.domain;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fse.taskmanager.dto.ParentTaskDto;
import com.fse.taskmanager.entity.ParentTaskEO;
import com.fse.taskmanager.repository.IParentTaskRepository;
/**
 * The Class ParentTaskDomainTest.
 */
public class ParentTaskDomainTest {

    /** The mock parent task repo. */
    @Mock
    private IParentTaskRepository mockParentTaskRepo;

    /** The parent task domain under test. */
    @InjectMocks
    private ParentTaskDomain parentTaskDomainUnderTest;

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
        // Setup
    	final ParentTaskDto dto = new ParentTaskDto();
    	dto.setParentId(1);
    	dto.setParentTask("Parent");
        final List<ParentTaskDto> expectedResult = Arrays.asList(dto);
        final ParentTaskEO eo1 = new ParentTaskEO();
        eo1.setParentId(1);
        eo1.setParentTask("Parent");
        when(mockParentTaskRepo.findAll()).thenReturn(Arrays.asList(eo1));

        // Run the test
        final List<ParentTaskDto> result = parentTaskDomainUnderTest.getParentTasks();

        // Verify the results
        Assert.assertEquals(expectedResult.get(0).getParentTask(), result.get(0).getParentTask());
    }

    /**
     * Test get parent task by id.
     */
    @Test
    public void testGetParentTaskById() {
        // Setup
        final ParentTaskDto expectedResult = new ParentTaskDto();
        when(mockParentTaskRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(new ParentTaskEO());

        // Run the test
        final ParentTaskDto result = parentTaskDomainUnderTest.getParentTaskById(1);

    }
}
