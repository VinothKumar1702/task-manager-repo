/*
 * 
 */
package com.fse.taskmanager.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectEO.
 */
@Entity
@Table(name ="project")
public class ProjectEO {

	/** The task id. */
	@Id
	@Column(name = "project_id",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;

	/** The project name. */
	@Column(name="project_name")
	private String projectName;
	
	/** The priority. */
	@Column(name = "priority")
	private int priority;
	
	/** The start date. */
	@Column(name = "start_date")
	private Date startDate;
	
	/** The end date. */
	@Column(name = "end_Date")
	private Date endDate;
	
	/** The user eo. */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersEO userEo;

	/**
	 * Gets the project id.
	 *
	 * @return the project id
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * Sets the project id.
	 *
	 * @param projectId the new project id
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gets the project name.
	 *
	 * @return the project name
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Sets the project name.
	 *
	 * @param projectName the new project name
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 *
	 * @param priority the new priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the user eo.
	 *
	 * @return the user eo
	 */
	public UsersEO getUserEo() {
		return userEo;
	}

	/**
	 * Sets the user eo.
	 *
	 * @param userEo the new user eo
	 */
	public void setUserEo(UsersEO userEo) {
		this.userEo = userEo;
	}
	
	
}
