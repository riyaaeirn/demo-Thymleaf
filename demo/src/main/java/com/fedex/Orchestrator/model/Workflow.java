package com.fedex.Orchestrator.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "workflow")
public class Workflow {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "workflow_name")
	private String name;

	@Column(name = "workflow_created_user")
	private String user;

	@Column(name = "workflow_status")
	private String status;

	@OneToMany(targetEntity=Task.class,cascade=CascadeType.ALL)
	@JoinColumn(name="workflowID",referencedColumnName="id")
	private List<Task> tasks;
	 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
