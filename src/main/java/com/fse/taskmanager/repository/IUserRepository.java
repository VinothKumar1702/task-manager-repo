package com.fse.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fse.taskmanager.entity.UsersEO;

@Repository
public interface IUserRepository extends JpaRepository<UsersEO, Integer>{

}
