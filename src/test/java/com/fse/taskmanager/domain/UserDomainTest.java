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
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fse.taskmanager.domain.UserDomain;
import com.fse.taskmanager.dto.UserDTO;
import com.fse.taskmanager.entity.UsersEO;
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
        final UserDTO userDto = getUserDto();
        final UserDTO expectedResult = getUserDto();
        UsersEO eo = getUserEo();
        when(mockUserRepo.save(ArgumentMatchers.any(UsersEO.class))).thenReturn(eo);

        // Run the test
        final UserDTO result = userDomainUnderTest.addUser(userDto);

        // Verify the results
        assertEquals(expectedResult.getEmployeeId(), result.getEmployeeId());
    }

    private UsersEO getUserEo() {
    	UsersEO eo = new UsersEO();
    	eo.setEmployeeId(1);
    	eo.setFirstName("vinoth");
    	eo.setLastName("kumar");
    	eo.setUserID(1);
		return eo;
	}

	private UserDTO getUserDto() {
		UserDTO dto = new UserDTO();
		dto.setEmployeeId(1);
		dto.setFirstName("vinoth");
		dto.setLastName("kumar");
		dto.setUserId(1);
		return dto;
	}

	@Test
    public void testViewUsers() {
        // Setup
        final List<UserDTO> expectedResult = Arrays.asList(getUserDto());
        when(mockUserRepo.findAll()).thenReturn(Arrays.asList(getUserEo()));

        // Run the test
        final List<UserDTO> result = userDomainUnderTest.viewUsers();

        // Verify the results
        assertEquals(expectedResult.get(0).getEmployeeId(), result.get(0).getEmployeeId());
    }

    @Test
    public void testDeleteUsers() {
        // Setup
        final int userID = 1;

        // Run the test
        final boolean result = userDomainUnderTest.deleteUsers(userID);

        // Verify the results
        verify(mockUserRepo).deleteById(null);
    }

    @Test
    public void testEditUsers() {
        // Setup
        final UserDTO userDto = getUserDto();
        final UserDTO expectedResult = getUserDto();
        when(mockUserRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(getUserEo());
        when(mockUserRepo.save(ArgumentMatchers.any(UsersEO.class))).thenReturn(getUserEo());

        // Run the test
        final UserDTO result = userDomainUnderTest.editUsers(userDto);

        // Verify the results
        assertEquals(expectedResult.getEmployeeId(), result.getEmployeeId());
    }

    @Test
    public void testGetUserById() {
        // Setup
        final int userID = 1;
        final UserDTO expectedResult = getUserDto();
        when(mockUserRepo.getOne(ArgumentMatchers.anyInt())).thenReturn(getUserEo());

        // Run the test
        final UserDTO result = userDomainUnderTest.getUserById(userID);

        // Verify the results
        assertEquals(expectedResult.getEmployeeId(), result.getEmployeeId());
    }

    @Test
    public void testGetuserByProjectId() {
        // Setup
        final int projectId = 1;
        final UserDTO expectedResult = getUserDto();

        // Run the test
        final UserDTO result = userDomainUnderTest.getuserByProjectId(projectId);

    }
}
