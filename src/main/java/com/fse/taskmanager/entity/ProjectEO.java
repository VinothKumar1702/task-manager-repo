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

@Entity
@Table(name ="project")
public class ProjectEO {

	/** The task id. */
	@Id
	@Column(name = "project_id",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;

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
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersEO userEo;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public UsersEO getUserEo() {
		return userEo;
	}

	public void setUserEo(UsersEO userEo) {
		this.userEo = userEo;
	}
	
	
}
