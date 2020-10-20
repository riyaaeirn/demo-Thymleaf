package com.fedex.Orchestrator.service;

import java.util.List;

import com.fedex.Orchestrator.model.Workflow;

public interface WorkflowService {
	List<Workflow> getAllWorkflows();
	void saveWorkflow(Workflow workflow);
	Workflow getWorkflowById(long id);
	void deleteWorkflowById(long id);
}
