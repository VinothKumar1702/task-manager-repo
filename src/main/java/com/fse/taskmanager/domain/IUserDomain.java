package com.fse.taskmanager.domain;

import java.util.List;

import com.fse.taskmanager.dto.UserDTO;

public interface IUserDomain {

	UserDTO addTask(UserDTO userDto);

	List<UserDTO> viewUsers();

	boolean deleteUsers(int userID);

	UserDTO editUsers(UserDTO userDto);

	UserDTO getUserById(int userID);

	UserDTO getuserByProjectId(int projectId);

}
