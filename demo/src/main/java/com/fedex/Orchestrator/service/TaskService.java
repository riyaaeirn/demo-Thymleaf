package com.fedex.Orchestrator.service;

import java.util.List;

import com.fedex.Orchestrator.model.Task;

public interface TaskService {

	List<Task> getAllTask();

	List<Task> findByWorkflowId(long id);

}
