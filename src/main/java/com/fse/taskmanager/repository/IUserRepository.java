package com.fse.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fse.taskmanager.entity.UsersEO;

@Repository
public interface IUserRepository extends JpaRepository<UsersEO, Integer>{

	@Query(value="select userEo from UsersEO userEo where userEo.project.projectId = :projectId")
	UsersEO getManager(@Param("projectId")int projectId);

	@Query(value="select userEo from UsersEO userEo where userEo.project.projectId = :projectId")
	UsersEO getuserByProjectId(@Param("projectId")int projectId);

	@Query(value="select userEo from UsersEO userEo where userEo.userID = :userId")
	UsersEO getuserByUserId(@Param("userId")int userId);
}
