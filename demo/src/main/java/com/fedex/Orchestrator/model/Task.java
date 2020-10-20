package com.fedex.Orchestrator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "task")
public class Task {

	@Id
	@Column(name = "task_id")
	private long taskId;

	@Column(name = "task_name")
	private String taskName;

	@Column(name = "task_status")
	private String taskStatus;

	
	private long workflowID;
	
	
	
	public long getWorkflowID() {
		return workflowID;
	}

	public void setWorkflowID(long workflowID) {
		this.workflowID = workflowID;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

}
