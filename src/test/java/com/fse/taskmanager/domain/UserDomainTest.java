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

import com.fse.taskmanager.domain.UserDomain;
import com.fse.taskmanager.dto.UserDTO;
import com.fse.taskmanager.repository.IUserRepository;

public class UserDomainTest {

    @Mock
    private IUserRepository mockUserRepo;

    @InjectMocks
    private UserDomain userDomainUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testAddUser() {
        // Setup
        final UserDTO userDto = null;
        final UserDTO expectedResult = null;
        when(mockUserRepo.save(null)).thenReturn(null);

        // Run the test
        final UserDTO result = userDomainUnderTest.addUser(userDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testViewUsers() {
        // Setup
        final List<UserDTO> expectedResult = Arrays.asList();
        when(mockUserRepo.findAll()).thenReturn(Arrays.asList());

        // Run the test
        final List<UserDTO> result = userDomainUnderTest.viewUsers();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDeleteUsers() {
        // Setup
        final int userID = 0;

        // Run the test
        final boolean result = userDomainUnderTest.deleteUsers(userID);

        // Verify the results
        assertTrue(result);
        verify(mockUserRepo).deleteById(null);
    }

    @Test
    public void testEditUsers() {
        // Setup
        final UserDTO userDto = null;
        final UserDTO expectedResult = null;
        when(mockUserRepo.getOne(null)).thenReturn(null);
        when(mockUserRepo.save(null)).thenReturn(null);

        // Run the test
        final UserDTO result = userDomainUnderTest.editUsers(userDto);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetUserById() {
        // Setup
        final int userID = 0;
        final UserDTO expectedResult = null;
        when(mockUserRepo.getOne(null)).thenReturn(null);

        // Run the test
        final UserDTO result = userDomainUnderTest.getUserById(userID);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetuserByProjectId() {
        // Setup
        final int projectId = 0;
        final UserDTO expectedResult = null;

        // Run the test
        final UserDTO result = userDomainUnderTest.getuserByProjectId(projectId);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
