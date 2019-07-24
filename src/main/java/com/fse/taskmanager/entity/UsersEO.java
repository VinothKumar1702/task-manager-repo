/*
 * 
 */
package com.fse.taskmanager.entity;


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
 * The Class UsersEO.
 */
@Entity
@Table(name="users")
public class UsersEO {

	/** The task id. */
	@Id
	@Column(name = "user_id",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	/** The parent task. */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<TaskEO> task;
	
	/** The project. */
	@OneToMany(mappedBy = "userEo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ProjectEO> project;
	
	/** The priority. */
	@Column(name = "employee_id")
	private int employeeId;
	
	
	/** The task. */
	@Column(name = "first_name")
	private String firstName;
	
	/** The last name. */
	@Column(name="last_name")
	private String lastName;

	/**
	 * Gets the user ID.
	 *
	 * @return the user ID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * Sets the user ID.
	 *
	 * @param userID the new user ID
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * Gets the task.
	 *
	 * @return the task
	 */
	public Set<TaskEO> getTask() {
		return task;
	}

	/**
	 * Sets the task.
	 *
	 * @param task the new task
	 */
	public void setTask(Set<TaskEO> task) {
		this.task = task;
	}

	/**
	 * Gets the project.
	 *
	 * @return the project
	 */
	public Set<ProjectEO> getProject() {
		return project;
	}

	/**
	 * Sets the project.
	 *
	 * @param project the new project
	 */
	public void setProject(Set<ProjectEO> project) {
		this.project = project;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
