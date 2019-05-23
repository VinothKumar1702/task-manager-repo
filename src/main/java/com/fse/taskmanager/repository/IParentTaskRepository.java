package com.fse.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fse.taskmanager.entity.ParentTaskEO;

@Repository
public interface IParentTaskRepository extends JpaRepository<ParentTaskEO, Integer>{

	
}
