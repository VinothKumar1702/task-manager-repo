package com.fse.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fse.taskmanager.entity.TaskEO;

/**
 * The Interface ITaskRepositroy.
 */
@Repository
public interface ITaskRepositroy extends JpaRepository<TaskEO, Integer> {

}
