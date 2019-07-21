package com.fse.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fse.taskmanager.entity.TaskEO;

/**
 * The Interface ITaskRepositroy.
 */
@Repository
public interface ITaskRepositroy extends JpaRepository<TaskEO, Integer> {

	@Query(value="select task from TaskEO task where task.project.projectId=:projectId")
	List<TaskEO> findProjects(@Param("projectId")int projectId);

	@Query(value="select task from TaskEO task where task.status ='COMPLETED' and task.project.projectId=:projectId")
	List<TaskEO> getcompletedProjects(@Param("projectId")int projectId);

}
