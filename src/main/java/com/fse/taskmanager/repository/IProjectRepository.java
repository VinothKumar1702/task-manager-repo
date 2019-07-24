/*
 * 
 */
package com.fse.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fse.taskmanager.entity.ProjectEO;

// TODO: Auto-generated Javadoc
/**
 * The Interface IProjectRepository.
 */
@Repository
public interface IProjectRepository extends JpaRepository<ProjectEO, Integer>  {

	/**
	 * Gets the project by P name.
	 *
	 * @param project the project
	 * @return the project by P name
	 */
	@Query(value="select project from ProjectEO project where project.projectName= :project")
	ProjectEO getProjectByPName(@Param ("project")String project);

}
