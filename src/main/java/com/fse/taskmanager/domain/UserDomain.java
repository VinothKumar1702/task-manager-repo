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

// TODO: Auto-generated Javadoc
/**
 * The Class UserDomain.
 *
 * @author Vinoth
 */
@Component
public class UserDomain implements IUserDomain{

	/** The user repo. */
	@Autowired
	private IUserRepository userRepo;
	
	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IUserDomain#addUser(com.fse.taskmanager.dto.UserDTO)
	 */
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

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IUserDomain#viewUsers()
	 */
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

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IUserDomain#deleteUsers(int)
	 */
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

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IUserDomain#editUsers(com.fse.taskmanager.dto.UserDTO)
	 */
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

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IUserDomain#getUserById(int)
	 */
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

	/* (non-Javadoc)
	 * @see com.fse.taskmanager.domain.IUserDomain#getuserByProjectId(int)
	 */
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
