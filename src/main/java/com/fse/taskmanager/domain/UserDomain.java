/**
 * 
 */
package com.fse.taskmanager.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fse.taskmanager.dto.UserDTO;
import com.fse.taskmanager.entity.UsersEO;
import com.fse.taskmanager.repository.IUserRepository;

/**
 * @author Vinoth
 *
 */
@Component
public class UserDomain implements IUserDomain{

	@Autowired
	private IUserRepository userRepo;
	
	@Override
	@Transactional(readOnly = false)
	public UserDTO addUser(UserDTO userDto) {
		UsersEO userEo = new UsersEO();
		userEo.setFirstName(userDto.getFirstName());
		userEo.setLastName(userDto.getLastName());
		userEo.setEmployeeId(userDto.getEmployeeId());
		userRepo.save(userEo);
		if(null!=userEo) {
			userDto.setUserId(userEo.getUserID());
		}
		return userDto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> viewUsers() {
		List<UserDTO> users = new ArrayList<>();
		List<UsersEO> userEo = userRepo.findAll();
		userEo.stream().forEach(user->{
			UserDTO userDto = new UserDTO();
			userDto.setEmployeeId(user.getEmployeeId());
			userDto.setUserId(user.getUserID());
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			users.add(userDto);
		});
		return users;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteUsers(int userID) {
		boolean delete = false;
		if (userID > 0) {
			userRepo.deleteById(userID);
			delete = true;
		}
		return delete;
	}

	@Override
	@Transactional(readOnly = false)
	public UserDTO editUsers(UserDTO userDto) {
		UsersEO userseo = userRepo.getOne(userDto.getUserId());
		userseo.setEmployeeId(userDto.getEmployeeId());
		userseo.setFirstName(userDto.getFirstName());
		userseo.setLastName(userDto.getLastName());
		userRepo.save(userseo);
		return userDto;
	}

	@Override
	public UserDTO getUserById(int userID) {
		UsersEO userseo = userRepo.getOne(userID);
		UserDTO userDto = null;
		if(null!=userseo) {
			userDto = new UserDTO();
			userDto.setUserId(userseo.getUserID());
			userDto.setEmployeeId(userseo.getEmployeeId());
			userDto.setFirstName(userseo.getFirstName());
			userDto.setLastName(userseo.getLastName());
		}
		return userDto;
	}

	@Override
	public UserDTO getuserByProjectId(int projectId) {
		//UsersEO userseo = userRepo.getuserByProjectId(projectId);
		UserDTO userDto = null;
		/*
		 * if(null!=userseo) { userDto = new UserDTO();
		 * userDto.setUserId(userseo.getUserID());
		 * userDto.setEmployeeId(userseo.getEmployeeId());
		 * userDto.setFirstName(userseo.getFirstName());
		 * userDto.setLastName(userseo.getLastName()); }
		 */
		return userDto;
	}
}
