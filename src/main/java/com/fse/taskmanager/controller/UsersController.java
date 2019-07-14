package com.fse.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fse.taskmanager.domain.IUserDomain;
import com.fse.taskmanager.dto.UserDTO;

/**
 * The Class UsersController.
 */
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private IUserDomain userDomain;
	/**
	 * Adds the user.
	 *
	 * @param userDto the user Dto 
	 * @return the user dto
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public UserDTO addUsers(@RequestBody final UserDTO userDto)  {
		final UserDTO userDtoResp = userDomain.addTask(userDto);
		return userDtoResp;
	}
	
	/**
	 * View Users.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/view-all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UserDTO> viewUsers()  {
		final List<UserDTO> viewUserResponse = userDomain.viewUsers();
		return viewUserResponse;
	}	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public UserDTO getUserById(@RequestParam final int userId)  {
		final UserDTO viewTaskResponse = userDomain.getUserById(userId);
		return viewTaskResponse;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public boolean deleteUser(@RequestParam final int userId)  {
		final boolean delResponse = userDomain.deleteUsers(userId);
		return delResponse;
	}	
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public UserDTO editUser(@RequestBody final UserDTO userDto)  {
		final UserDTO editResponse = userDomain.editUsers(userDto);
		return editResponse;
	}	
}
