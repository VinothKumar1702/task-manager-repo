package com.fse.taskmanager.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne
	@JoinColumn(name = "Task_ID")
	private TaskEO task;
	
	/** The project. */
	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectEO project;
	
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

	public TaskEO getTask() {
		return task;
	}

	public void setTask(TaskEO task) {
		this.task = task;
	}

	public ProjectEO getProject() {
		return project;
	}

	public void setProject(ProjectEO project) {
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
