/*
 * 
 */
package com.fse.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fse.taskmanager.entity.TaskEO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ITaskRepositroy.
 */
@Repository
public interface ITaskRepositroy extends JpaRepository<TaskEO, Integer> {

	/**
	 * Find projects.
	 *
	 * @param projectId the project id
	 * @return the list
	 */
	@Query(value="select task from TaskEO task where task.project.projectId=:projectId")
	List<TaskEO> findProjects(@Param("projectId")int projectId);

	/**
	 * Gets the completed projects.
	 *
	 * @param projectId the project id
	 * @return the completed projects
	 */
	@Query(value="select task from TaskEO task where task.status ='COMPLETED' and task.project.projectId=:projectId")
	List<TaskEO> getcompletedProjects(@Param("projectId")int projectId);

}
