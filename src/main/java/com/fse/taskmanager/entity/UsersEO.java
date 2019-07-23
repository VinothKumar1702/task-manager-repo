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
	
	@Column(name="last_name")
	private String lastName;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Set<TaskEO> getTask() {
		return task;
	}

	public void setTask(Set<TaskEO> task) {
		this.task = task;
	}

	public Set<ProjectEO> getProject() {
		return project;
	}

	public void setProject(Set<ProjectEO> project) {
		this.project = project;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
