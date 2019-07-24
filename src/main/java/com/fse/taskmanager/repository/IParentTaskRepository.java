/*
 * 
 */
package com.fse.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fse.taskmanager.entity.ParentTaskEO;

// TODO: Auto-generated Javadoc
/**
 * The Interface IParentTaskRepository.
 */
@Repository
public interface IParentTaskRepository extends JpaRepository<ParentTaskEO, Integer>{

	/**
	 * Fetch parent task by name.
	 *
	 * @param parentTask the parent task
	 * @return the parent task EO
	 */
	@Query(value="select parent from ParentTaskEO parent where parent.parentTask = :parentTask")
	ParentTaskEO fetchParentTaskByName(@Param("parentTask")String parentTask);

	
}
