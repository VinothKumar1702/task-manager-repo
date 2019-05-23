package com.fse.taskmanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parent")
public class ParentTaskEO {
	
	@Id
	@Column(name = "Parent_ID",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parentId;
	
	@Column(name = "Parent_Task")
	private String parentTask;
	
	@OneToMany(mappedBy = "parentTask", cascade = CascadeType.ALL)
	private List<TaskEO> taskList;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public List<TaskEO> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskEO> taskList) {
		this.taskList = taskList;
	}
	
	
}
