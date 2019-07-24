package com.fse.taskmanager.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.taskmanager.domain.IUserDomain;
import com.fse.taskmanager.dto.UserDTO;

/**
 * The Class UserControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	/** The user domain. */
	@Mock
	private IUserDomain userDomain;
	
	/** The controller. */
	@InjectMocks
	private UsersController controller;
	
	/**
	 * Test get users.
	 */
	@Test
	public void testGetUsers() {
		final List<UserDTO> viewUserResponse = controller.viewUsers();
	}
	
	/**
	 * Test get user by id.
	 */
	@Test
	public void testGetUserById() {
		final UserDTO viewUserResponse = controller.getUserById(ArgumentMatchers.anyInt());
	}
	
	/**
	 * Test get user by project id.
	 */
	@Test
	public void testGetUserByProjectId() {
		final UserDTO response = controller.getuserByProjectId(ArgumentMatchers.anyInt());
	}

	/**
	 * Tes add user.
	 */
	@Test
	public void tesAddUser() {
		final UserDTO response = controller.addUsers(ArgumentMatchers.any(UserDTO.class));
	}
	
	/**
	 * Test delet user.
	 */
	@Test
	public void testDeletUser() {
		final boolean deleteUser= controller.deleteUser(ArgumentMatchers.anyInt());
	}
	
	/**
	 * Tes edit user.
	 */
	@Test
	public void tesEditUser() {
		final UserDTO response = controller.editUser(ArgumentMatchers.any(UserDTO.class));
	}
}
