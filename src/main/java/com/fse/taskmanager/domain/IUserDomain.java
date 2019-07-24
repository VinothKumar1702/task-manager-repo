/*
 * 
 */
package com.fse.taskmanager.domain;

import java.util.List;

import com.fse.taskmanager.dto.UserDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUserDomain.
 */
public interface IUserDomain {

	/**
	 * Adds the user.
	 *
	 * @param userDto the user dto
	 * @return the user DTO
	 */
	UserDTO addUser(UserDTO userDto);

	/**
	 * View users.
	 *
	 * @return the list
	 */
	List<UserDTO> viewUsers();

	/**
	 * Delete users.
	 *
	 * @param userID the user ID
	 * @return true, if successful
	 */
	boolean deleteUsers(int userID);

	/**
	 * Edits the users.
	 *
	 * @param userDto the user dto
	 * @return the user DTO
	 */
	UserDTO editUsers(UserDTO userDto);

	/**
	 * Gets the user by id.
	 *
	 * @param userID the user ID
	 * @return the user by id
	 */
	UserDTO getUserById(int userID);

	/**
	 * Gets the user by project id.
	 *
	 * @param projectId the project id
	 * @return the user by project id
	 */
	UserDTO getuserByProjectId(int projectId);

}
