package com.fse.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fse.taskmanager.entity.ProjectEO;

@Repository
public interface IProjectRepository extends JpaRepository<ProjectEO, Integer>  {

	@Query(value="select project from ProjectEO project where project.projectName= :project")
	ProjectEO getProjectByPName(@Param ("project")String project);

}
